package thank267.commons.configs;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.connection.ConnectionPoolSettings;
import com.mongodb.connection.SocketSettings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MultipleMongoProperties.class)
public class MultipleMongoConfig {

	@Autowired
	private MultipleMongoProperties mongoProperties;

	@Bean
	public MongoClientSettings mongoPropertiesOptions() {

		MongoClientSettings.Builder builder = MongoClientSettings.builder();
		SocketSettings socketSettings = SocketSettings.builder().connectTimeout(50000, TimeUnit.MILLISECONDS).build();
		ConnectionString connectionString = new ConnectionString(mongoProperties.getProperties().determineUri());
		return builder.applyToSocketSettings(builder1 -> builder1.applySettings(socketSettings)).applyConnectionString(connectionString).applyToConnectionPoolSettings(connPoolBuilder -> ConnectionPoolSettings.builder().maxSize(10).build()).build();
	}

	@Bean
	public MongoClientSettings mongoRobotsOptions() {

		MongoClientSettings.Builder builder = MongoClientSettings.builder();
		SocketSettings socketSettings = SocketSettings.builder().connectTimeout(50000, TimeUnit.MILLISECONDS).build();
		ConnectionString connectionString = new ConnectionString(mongoProperties.getRobots().determineUri());
		return builder.applyToSocketSettings(builder1 -> builder1.applySettings(socketSettings)).applyConnectionString(connectionString).build();
	}

	@Bean
	public MongoClientSettings mongoAdminOptions() {

		MongoClientSettings.Builder builder = MongoClientSettings.builder();
		SocketSettings socketSettings = SocketSettings.builder().connectTimeout(50000, TimeUnit.MILLISECONDS).build();
		ConnectionString connectionString = new ConnectionString(mongoProperties.getAdmin().determineUri());
		log.info("connectionString {}", connectionString);
		return builder.applyToSocketSettings(builder1 -> builder1.applySettings(socketSettings)).applyConnectionString(connectionString).build();
	}

	@Bean(name = "robotsMongoTemplate")
	public MongoTemplate robotsMongoTemplate() throws Exception {
		return new MongoTemplate(MongoClients.create(mongoRobotsOptions()), getMongoProperties().getRobots().getDatabase());
	}

	@Bean(name = "propertiesMongoTemplate")
	public MongoTemplate propertiesMongoTemplate() throws Exception {
		return new MongoTemplate(MongoClients.create(mongoPropertiesOptions()), getMongoProperties().getProperties().getDatabase());
	}

	public MultipleMongoProperties getMongoProperties() {
		return mongoProperties;
	}

	public void setMongoProperties(MultipleMongoProperties mongoProperties) {
		this.mongoProperties = mongoProperties;
	}

	@Qualifier("propertyFlyers")
	@Bean
	public GridFsTemplate propertyFlyersGridFsTemplate() throws Exception {
		return new GridFsTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(mongoPropertiesOptions()), getMongoProperties().getProperties().getDatabase()), propertiesMongoTemplate().getConverter(), "propertyFlyers");

	}

	@Qualifier("serviceFlyers")
	@Bean
	public GridFsTemplate serviceFlyersGridFsTemplate() throws Exception {
		return new GridFsTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(mongoPropertiesOptions()), getMongoProperties().getProperties().getDatabase()), propertiesMongoTemplate().getConverter(), "serviceFlyers");

	}

	@Bean
	public MongoClient mongoAdmin() {
		log.info("mongoAdminOptions {}", mongoAdminOptions());
		return MongoClients.create(mongoAdminOptions());
	}

}

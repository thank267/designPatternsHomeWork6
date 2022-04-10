package thank267.commons.configs;

import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {

	private MongoProperties robots = new MongoProperties();
	private MongoProperties properties = new MongoProperties();
	private MongoProperties admin = new MongoProperties();

}

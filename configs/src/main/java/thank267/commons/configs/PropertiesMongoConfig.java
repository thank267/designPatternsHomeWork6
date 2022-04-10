package thank267.commons.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "thank267.commons.repository.properties", mongoTemplateRef = "propertiesMongoTemplate")
public class PropertiesMongoConfig {

}

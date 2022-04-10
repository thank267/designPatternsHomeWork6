package thank267.commons.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "holding")
public class ConfigLinks {

	private final Map<String, String> links = new HashMap<>();

	public Map<String, String> getLinks() {
		return this.links;
	}

}

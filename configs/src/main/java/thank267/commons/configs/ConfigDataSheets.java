package thank267.commons.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "templating.renderers")
public class ConfigDataSheets {

	private final Map<String, String> GenerateProperty = new HashMap<>();

	public Map<String, String> getGenerateProperty() {
		return this.GenerateProperty;
	}

}

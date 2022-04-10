package thank267.commons.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "")
public class ConfigPriceVariations {

	private Map<String, Variation> priceVariations = new HashMap<>();

	public Map<String, Variation> getPriceVariations() {
		return this.priceVariations;
	}

	public void setPriceVariations(Map<String, Variation> priceVariations) {
		this.priceVariations = priceVariations;
	}

	public static class Variation {

		private String description;
		private Map<String, String> variations;

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Map<String, String> getVariations() {
			return variations;
		}

		public void setVariations(Map<String, String> variations) {
			this.variations = variations;
		}

	}

}

package thank267.commons.configs;

import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thank267.commons.models.Holding;

@Slf4j
@Configuration
public class ConfigHolding {

	@Value("${holding}")
	String holding;

	@Bean
	public Holding getHolding() {

		Document doc = Document.parse(holding);

		Holding holding = new Holding();
		holding.setHolding(doc);
		log.info("holding INIT");

		return holding;
	}

}

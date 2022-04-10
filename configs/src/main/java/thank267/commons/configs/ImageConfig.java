package thank267.commons.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ImageConfig {

	@Value("${baseWidth: 1024.0}")
	private Double baseWidth;

	@Value("${baseWidth*4000/6016: #{1024.0*4000.0/6016.0}}")
	private Double baseHeight;

	@Bean
	public Double getBaseWidth() {

		return baseWidth;
	}

	@Bean
	public Double getBaseHeight() {

		return baseHeight;
	}

}

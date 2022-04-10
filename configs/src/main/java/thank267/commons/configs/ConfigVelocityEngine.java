package thank267.commons.configs;

import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thank267.commons.repository.MapResourceLoader;

@Slf4j
@Configuration
public class ConfigVelocityEngine {

	@Autowired
	private ConfigDataSheets root;

	@Bean
	public VelocityEngine getVelocityEngine() {

		VelocityEngine ve = new VelocityEngine();

		MapResourceLoader rl = new MapResourceLoader(root.getGenerateProperty());

		ve.setProperty(Velocity.RESOURCE_LOADERS, "map");
		ve.addProperty("resource.loader.map.instance", rl);
		ve.init();

		return ve;
	}

}

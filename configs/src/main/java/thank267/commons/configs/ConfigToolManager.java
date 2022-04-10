package thank267.commons.configs;

import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.config.EasyFactoryConfiguration;
import org.apache.velocity.tools.generic.NumberTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ConfigToolManager {

	@Autowired
	private ConfigVelocityEngine ConfigVelocityEngine;

	@Bean
	public ToolManager getToolManager() {

		ToolManager toolManager = new ToolManager();

		EasyFactoryConfiguration config = new EasyFactoryConfiguration();
		config.tool(BooleanToString.class).tool(NumberTool.class).property("locale", "ru_RU");

		toolManager.configure(config);

		toolManager.setVelocityEngine(ConfigVelocityEngine.getVelocityEngine());

		log.info("ToolManager INIT");

		return toolManager;
	}

}

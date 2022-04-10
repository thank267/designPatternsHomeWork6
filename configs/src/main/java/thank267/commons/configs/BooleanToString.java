package thank267.commons.configs;

import org.apache.velocity.tools.config.DefaultKey;

import java.util.Optional;

@DefaultKey("bool")
public class BooleanToString {

	public String message(Boolean value, String toRender) {

		if (Optional.ofNullable(value).isPresent() && value) {
			return toRender;
		} else

			return null;

	}

}

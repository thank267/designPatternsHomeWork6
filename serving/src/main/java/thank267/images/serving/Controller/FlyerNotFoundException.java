package thank267.images.serving.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.NOT_FOUND)
public class FlyerNotFoundException extends RuntimeException {

	public FlyerNotFoundException(String message) {

		super(message);

	}

}

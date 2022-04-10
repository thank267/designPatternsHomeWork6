package thank267.images.serving.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import thank267.images.serving.Service.FlyerService;

@Slf4j
@RestController
public class FlyersController {

	@Autowired
	FlyerService flayerService;

	@GetMapping(value = "/propertyFlyers/{name}.pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public @ResponseBody
	byte[] getPropertyFlyer(@PathVariable("name") String name) {

		return flayerService.getPropertyFlyer(name);

	}

	@GetMapping(value = "/serviceFlyers/{name}.pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public @ResponseBody
	byte[] getServiceFlyer(@PathVariable("name") String name) {

		return flayerService.getServiceFlyer(name);

	}

}

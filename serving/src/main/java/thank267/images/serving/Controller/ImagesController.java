package thank267.images.serving.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import thank267.images.serving.Service.ImageService;

@Slf4j
@RestController
public class ImagesController {

	@Autowired
	ImageService ImageService;

	@GetMapping(value = "/images/{id}/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody
	byte[] getImage(@PathVariable("id") Integer id, @PathVariable("name") String name) {

		return ImageService.getImage(id, name);

	}

	@GetMapping(value = "/catimage/{id}/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody
	byte[] getCatImage(@PathVariable("id") Integer id, @PathVariable("name") String name) {

		return ImageService.getCatImage(id, name);

	}

	@GetMapping(value = "/servimage/{id}/{name}.jpg", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody
	byte[] getServImage(@PathVariable("id") Integer id, @PathVariable("name") String name) {

		return ImageService.getServImage(id);

	}

	@GetMapping(value = "/photo/риэлтор_ан_новая_недвижимость_{surname}_{name}.jpg", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody
	byte[] getPhoto(@PathVariable("surname") String surname, @PathVariable("name") String name) {

		return ImageService.getPhoto(surname, name);

	}

}

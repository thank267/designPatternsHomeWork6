package thank267.images.serving.Service;

import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import thank267.images.serving.Controller.FlyerNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Slf4j
@Service

public class FlyerServiceImpl implements FlyerService {

	@Qualifier("propertyFlyers")
	@Autowired
	private GridFsTemplate propertyFlyersGridFsTemplate;

	@Qualifier("propertyFlyers")
	@Autowired
	private GridFsOperations propertyOperations;

	@Qualifier("serviceFlyers")
	@Autowired
	private GridFsTemplate serviceFlyersGridFsTemplate;

	@Qualifier("serviceFlyers")
	@Autowired
	private GridFsOperations serviceOperations;

	public byte[] getPropertyFlyer(String name) {

		try {

			Optional<GridFSFile> optionalFlyer = Optional.ofNullable(propertyFlyersGridFsTemplate.findOne(new Query(Criteria.where("metadata.name").is(name))));

			if (!optionalFlyer.isPresent()) {
				throw new FlyerNotFoundException("entity not found");

			}

			InputStream initialStream = propertyOperations.getResource(optionalFlyer.get()).getInputStream();

			byte[] targetArray = initialStream.readAllBytes();

			return targetArray;

		} catch (IOException e) {
			throw new RuntimeException("IOException in scale");
		}

	}

	public byte[] getServiceFlyer(String name) {

		try {

			Optional<GridFSFile> optionalFlyer = Optional.ofNullable(serviceFlyersGridFsTemplate.findOne(new Query(Criteria.where("metadata.name").is(name))));

			if (!optionalFlyer.isPresent()) {
				throw new FlyerNotFoundException("entity not found");

			}

			InputStream initialStream = serviceOperations.getResource(optionalFlyer.get()).getInputStream();

			byte[] targetArray = initialStream.readAllBytes();

			return targetArray;

		} catch (IOException e) {
			throw new RuntimeException("IOException in scale");
		}

	}

}

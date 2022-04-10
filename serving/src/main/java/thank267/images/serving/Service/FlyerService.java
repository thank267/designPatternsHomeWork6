package thank267.images.serving.Service;

import thank267.images.serving.Controller.FlyerNotFoundException;

public interface FlyerService {
	byte[] getPropertyFlyer(String name) throws FlyerNotFoundException;

	byte[] getServiceFlyer(String name) throws FlyerNotFoundException;

}

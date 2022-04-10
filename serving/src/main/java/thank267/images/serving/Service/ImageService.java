package thank267.images.serving.Service;

public interface ImageService {
	byte[] getImage(Integer id, String name);

	byte[] getCatImage(Integer id, String name);

	byte[] getServImage(Integer id);

	byte[] getPhoto(String surname, String name);

}

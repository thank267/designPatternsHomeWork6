package thank267.images.serving.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thank267.commons.configs.ImageConfig;
import thank267.commons.models.Holding;
import thank267.commons.models.Image;
import thank267.commons.models.ImageScaledEnum;
import thank267.commons.models.Rieltor;
import thank267.commons.repository.properties.ImageRepository;
import thank267.commons.repository.properties.ServiceRepository;
import thank267.commons.repository.robots.RieltorRepository;
import thank267.commons.utils.images.TransformUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

	final String copyRight = "\u00a9";

	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private RieltorRepository rieltorRepository;

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private Holding holding;

	@Autowired
	private ImageConfig imgageConfig;

	public byte[] getImage(Integer id, String name) {

		try {

			Optional<Image> optionalImage = imageRepository.findOne(id, name);

			if (optionalImage.isPresent()) {

				BufferedImage img = ImageIO.read(new ByteArrayInputStream(optionalImage.get().getImg().getData()));

				int type = BufferedImage.TYPE_INT_ARGB;
				if (img.getTransparency() == Transparency.OPAQUE) {
					type = BufferedImage.TYPE_INT_RGB;
				}
				BufferedImage watermarked = new BufferedImage(img.getWidth(), img.getHeight(), type);

				// initializes necessary graphic properties
				Graphics2D w = (Graphics2D) watermarked.getGraphics();
				w.drawImage(img, 0, 0, null);
				AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
				w.setComposite(alphaChannel);
				w.setColor(Color.GRAY);
				w.setFont(new Font(Font.SANS_SERIF, Font.BOLD, img.getHeight() / 30));

				//выводим название

				FontMetrics fontMetrics = w.getFontMetrics();

				String textToDraw = copyRight.concat(" ").concat(holding.getName());

				Rectangle2D rect = fontMetrics.getStringBounds(textToDraw, w);

				// calculate center of the image
				int centerX = (img.getWidth() - (int) rect.getWidth()) / 2;
				int centerY = img.getHeight() / 5;

				// add text overlay to the image
				w.drawString(textToDraw, centerX, centerY);

				// выводим логотип
				BufferedImage overlay = TransformUtil.rasterize(holding.getGreyLogo());
				overlay = TransformUtil.resize(overlay, img.getHeight() / 12, img.getHeight() / 12, ImageScaledEnum.FIT);

				// calculates the coordinate where the String is painted
				centerX = img.getWidth() / 2;
				centerY = img.getHeight() / 13;

				// add text watermark to the image
				w.drawImage(overlay, centerX, centerY, null);

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(watermarked, "jpg", baos);

				baos.flush();
				byte[] imageInByte = baos.toByteArray();
				baos.close();

				w.dispose();

				return imageInByte;

			} else

				return holding.decodeNoPhoto();

		} catch (IOException e) {
			throw new RuntimeException("IOException in scale");
		}

	}

	public byte[] getCatImage(Integer id, String name) {

		try {

			Optional<Image> optionalImage = imageRepository.findOne(id, name);

			if (optionalImage.isPresent()) {

				BufferedImage img = ImageIO.read(new ByteArrayInputStream(optionalImage.get().getImg().getData()));

				img = TransformUtil.resize(img, imgageConfig.getBaseWidth(), imgageConfig.getBaseHeight(), ImageScaledEnum.COVER);

				int x = (img.getWidth() - imgageConfig.getBaseWidth().intValue()) / 2;

				int y = (img.getHeight() - imgageConfig.getBaseHeight().intValue()) / 2;

				img = img.getSubimage(x, y, Math.min(img.getWidth(), imgageConfig.getBaseWidth().intValue()), Math.min(img.getHeight(), imgageConfig.getBaseHeight().intValue()));

				int type = BufferedImage.TYPE_INT_ARGB;
				if (img.getTransparency() == Transparency.OPAQUE) {
					type = BufferedImage.TYPE_INT_RGB;
				}
				BufferedImage watermarked = new BufferedImage(img.getWidth(), img.getHeight(), type);

				// initializes necessary graphic properties
				Graphics2D w = (Graphics2D) watermarked.getGraphics();
				w.drawImage(img, 0, 0, null);
				AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
				w.setComposite(alphaChannel);
				w.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
				w.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				w.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				w.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
				w.setColor(Color.GRAY);

				// выводим логотип
				BufferedImage overlay = TransformUtil.rasterize(holding.getGreyLogo());
				overlay = TransformUtil.resize(overlay, img.getHeight() / 12, img.getHeight() / 12, ImageScaledEnum.FIT);

				// calculates the coordinate where the String is painted
				int centerX = (int) (img.getWidth() / 1.1);
				int centerY = (int) (img.getHeight() / 1.15);

				// add text watermark to the image
				w.drawImage(overlay, centerX, centerY, null);

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(watermarked, "jpg", baos);

				baos.flush();
				byte[] imageInByte = baos.toByteArray();
				baos.close();

				w.dispose();

				return imageInByte;

			} else

				return holding.decodeNoPhoto();

		} catch (IOException e) {
			throw new RuntimeException("IOException in scale");
		}

	}

	public byte[] getServImage(Integer id) {

		try {

			Optional<thank267.commons.models.Service> optionalService = serviceRepository.findOne(id);

			if (optionalService.isPresent()) {

				BufferedImage img = ImageIO.read(new ByteArrayInputStream(optionalService.get().getImage().getData()));

				img = TransformUtil.resize(img, imgageConfig.getBaseWidth(), imgageConfig.getBaseHeight(), ImageScaledEnum.COVER);

				int x = (img.getWidth() - imgageConfig.getBaseWidth().intValue()) / 2;

				int y = (img.getHeight() - imgageConfig.getBaseHeight().intValue()) / 2;

				img = img.getSubimage(x, y, Math.min(img.getWidth(), imgageConfig.getBaseWidth().intValue()), Math.min(img.getHeight(), imgageConfig.getBaseHeight().intValue()));

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(img, "jpg", baos);

				baos.flush();
				byte[] imageInByte = baos.toByteArray();
				baos.close();

				return imageInByte;

			} else

				return holding.decodeNoPhoto();

		} catch (IOException e) {
			throw new RuntimeException("IOException in scale");
		}

	}

	public byte[] getPhoto(String surname, String name) {

		try {

			Optional<Rieltor> optionalRieltor = rieltorRepository.findByName(surname + " " + name);

			if (optionalRieltor.isPresent()) {

				return optionalRieltor.get().getPhoto().getData();

			} else

				return holding.decodeNoPhoto();

		} catch (Exception e) {
			throw new RuntimeException("IOException in scale");
		}

	}

}

package thank267.commons.models;

import java.util.Base64;
import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import lombok.Getter;
import lombok.Setter;


public class Holding {

	private final String logoBase64 = "data:image/png;base64,";
	private final String noPhotoBase64 = "data:image/jpg;base64,";
	
	@Getter
	@Setter
	private String logo;

	@Getter
	@Setter
	private String greyLogo;
	
	@Getter
	@Setter
	private String noPhoto;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String slogan;
	
	@Getter
	@Setter
	private String site;
	
	@Getter
	@Setter
	private String phone;
	
	@Getter
	@Setter
	private String address;

	
	@Getter
	@Setter
	private GeoJsonPoint geo;
	
	@Getter
	@Setter
	private Integer defaultPayer;
	
	public Double getLat() {
		return getGeo().getCoordinates().get(1);
	}
	
	public Double getLon() {
		return getGeo().getCoordinates().get(0);
	}

	public void setHolding(Document doc) {
	
		this.setName(doc.getString("name"));
		setSlogan(doc.getString("slogan"));
		setSite(doc.getString("site"));
		setPhone(doc.getString("phone"));
		setAddress(doc.getString("address"));
		
		Document tmpGeo  = doc.get("geo", Document.class);
		
		List<Double> coordinates;
		//noinspection JoinDeclarationAndAssignmentJava
		coordinates = (List<Double>) tmpGeo.get("coordinates");

		setGeo(new GeoJsonPoint(coordinates.get(0), coordinates.get(1)));
		
		setLogo(doc.getString("logo"));
		setGreyLogo(doc.getString("greyLogo"));
		setNoPhoto(doc.getString("noPhoto"));

		setDefaultPayer(doc.getInteger("defaultPayer"));
	}
	
	public byte[] decodeLogo() {
		return Base64.getDecoder().decode(getLogo());
	}

	public byte[] decodeNoPhoto() {
		return Base64.getDecoder().decode(getNoPhoto());
	}

	public String toSiteLogo() {
		return logoBase64+getLogo();
	}

	public String toSiteNoPhoto() {
		return noPhotoBase64+getNoPhoto();
	}
	

}
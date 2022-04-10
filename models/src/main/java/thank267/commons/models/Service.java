package thank267.commons.models;

import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection="service")
public class Service {

	@Id
    @Setter
    @Getter
    @BsonId
    @BsonProperty("_id")
    private ObjectId _id;

    @BsonProperty("id")
    @Setter
    @Getter
    private Integer id;
	
	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String shortName;
	
	@Getter
	@Setter
	private String teaser;

	@Getter
	@Setter
	private List<String> articles;
	
	@Getter
	@Setter
	private Binary image;

	@Getter
	@Setter
	private String operation;

	@Getter
	@Setter
	private Integer order;

	@Getter
	@Setter	
	private String parameter;

	@Getter
	@Setter	
	private Price price;

	@Getter
	@Setter
	private String value;

	public void setService(org.bson.Document doc) {
			
		this.setName(doc.getString("name"));
		setTeaser(doc.getString("teaser"));
		setImage(doc.get("image",Binary.class));
		setOperation(doc.getString("operation"));
		setParameter(doc.getString("parameter"));
		setValue(doc.getString("value"));
				
	}

}
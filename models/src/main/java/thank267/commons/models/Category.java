package thank267.commons.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="categories")
public class Category{
	
	@Getter
	@Setter
	private Integer order;
	
	@Getter
	@Setter
	private String title;
	
	@Getter
	@Setter
	private Boolean visible;
	
	@Getter
	@Setter
	private String page;
	
	@Getter
	@Setter
	private String _id;
	
}
package thank267.commons.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
public class PipelineWin extends Property {
 
	
	@Getter
	@Setter
	private List<Property> openProperties;

}
package thank267.commons.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


public class PriceChanged extends Property {

    @Getter
	@Setter
	private Integer old_value;
	
	@Getter
	@Setter
	private Date oldvalue_timestamp;


	

}
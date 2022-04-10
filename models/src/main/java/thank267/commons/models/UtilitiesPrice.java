package thank267.commons.models;

import lombok.Getter;
import lombok.Setter;

public class UtilitiesPrice {
	
	@Getter
	@Setter
	private Integer summer;
	
	@Getter
	@Setter
	private Integer winter;
	
	@Override
	public String toString() {
	
		return String.format(
				"зимой - %,d руб., летом - %,d руб.", 
				getWinter(),
				getSummer()
				);
	}

}
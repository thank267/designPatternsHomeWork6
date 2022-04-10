package thank267.commons.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


public class Right {
	
	@Getter
	@Setter
	private String type;
	
	@Getter
	@Setter
	private String typeBase;

	@Getter
	@Setter
	private String numberBase;

	@Getter
	@Setter
	private Date dateBase;

	@Getter
	@Setter
	private String typeConfirm;

	@Getter
	@Setter
	private String seriesConfirm;

	@Getter
	@Setter
	private String numberConfirm;

	@Getter
	@Setter
	private Date dateConfirm;
	
}
package thank267.commons.models;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Dimension {
	
	@Getter
	@Setter
	private Double length;
	
	@Getter
	@Setter
	private Double width;
	
	@Getter
	@Setter
	private Double height;

	public Dimension(Integer length, Integer width, Integer height){
		this.length= (double) length;
		this.width= (double) width;
		this.height= (double) height;

	}

	public Dimension(Double length, Double width, Double height){
		this.length= length;
		this.width= width;
		this.height= height;

	}
	
	@Override
	public String toString() {
		
		String pattern = "#.#";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		
		String collect =Stream.of(getLength(),getWidth(),getHeight())
				
				 .filter(Objects::nonNull)
				 .map(el -> decimalFormat.format(el))
				 .collect(Collectors.joining(" x "));
		 
		if (StringUtils.isBlank(collect)) return null;
		
		else return collect.concat(" м");
		
	}

}
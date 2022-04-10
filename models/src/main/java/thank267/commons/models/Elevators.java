package thank267.commons.models;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;


public class Elevators {
	
	@Getter
	@Setter
	private Integer passenger;
	
	@Getter
	@Setter
	private Integer cargo;
	
	@Override
	public String toString() {
		
		String[] elevators = {null, null};
		
		Optional.ofNullable(getPassenger()).ifPresent(i->{
			
			elevators[0] = "пассажирских - "+String.valueOf(i);
			
		});
		
        Optional.ofNullable(getCargo()).ifPresent(i->{
			
			elevators[1] = "грузовых - "+String.valueOf(i);
			
		});
		
        String collect = Arrays.stream(elevators)
        		.filter(Objects::nonNull)
        		.collect(Collectors.joining(", "));
				
		
        if (StringUtils.isBlank(collect)) return null;
		
		else return collect;
	
	}

}
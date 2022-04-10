package thank267.commons.models;


import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

public class WindowsOverlook {
	
	@Getter
	@Setter
	private Boolean yard;
	
	@Getter
	@Setter
	private Boolean street;
	
	@Override
	public String toString() {
		
		String[] windows = {null, null};
		
		Optional.ofNullable(getYard()).ifPresent(i->{
		
			if (getYard()) windows[0] = "во двор";
			
		});
		
        Optional.ofNullable(getStreet()).ifPresent(i->{
			
        	if (getStreet()) windows[1] = "на улицу";
			
			
		});
		
        String collect = Arrays.stream(windows)
        		.filter(Objects::nonNull)
        		.collect(Collectors.joining(", "));
        
        if (StringUtils.isBlank(collect)) return null;
		
		else return collect;
				
	}

}
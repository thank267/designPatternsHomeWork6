package thank267.commons.models;

import lombok.Getter;
import lombok.Setter;
import java.lang.Comparable;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

public class PriceOption implements Comparable<PriceOption> {

    @Getter
	@Setter
	private String parameter;

	@Getter
	@Setter
	private Price price;


	@Override public boolean equals(Object other) {
		if (!(other instanceof PriceOption)) {
		  return false;
		}
		PriceOption otherPriceOption = (PriceOption) other;
		return StringUtils.equals(getParameter(), otherPriceOption.getParameter()) ;
	  }
	
	@Override public int compareTo(PriceOption other) {
	// As of Java 7, this can be replaced with
	// return x != other.x ? Integer.compare(x, other.x) 
	//     : Integer.compare(y, other.y);

	return getParameter().compareTo(other.getParameter());

	
	}

	@Override
	public int hashCode() {
		return Objects.hash(getParameter());
	}

	@Override
	public String toString() {
		return String.format("parameter: %s, price: %s", getParameter(), getPrice());
	}
	
    
}
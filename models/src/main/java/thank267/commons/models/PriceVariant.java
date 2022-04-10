package thank267.commons.models;

import lombok.Getter;
import lombok.Setter;
import java.lang.Comparable;
import java.util.Objects;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;

public class PriceVariant implements Comparable<PriceVariant> {

    @Getter
	@Setter
	private String variant;
	
	@Getter
	@Setter
	private TreeSet<PriceOption> options;


	@Override public boolean equals(Object other) {
		if (!(other instanceof PriceVariant)) {
		  return false;
		}
		PriceVariant otherPriceVariant = (PriceVariant) other;
		return StringUtils.equals(getVariant(), otherPriceVariant.getVariant());
	  }
	
	@Override public int compareTo(PriceVariant other) {
	// As of Java 7, this can be replaced with
	// return x != other.x ? Integer.compare(x, other.x) 
	//     : Integer.compare(y, other.y);

		return getVariant().compareTo(other.getVariant());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getVariant());
	}
	
    
}
package thank267.commons.models;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import java.text.NumberFormat;

import lombok.Getter;
import lombok.Setter;


public class Price implements Comparable<Price> {

    @Getter
	@Setter
	private Integer price;
	
	@Getter
	@Setter
	private String priceUnit="рубль";

	@Getter
	@Setter
	private String description=null;

	@Getter
	@Setter
	private String name=null;

	@Getter
	@Setter
	private String parent=null;

	@Getter
	@Setter
	private String sign=null;

	@Getter
	@Setter
	private DurationEnum pricePeriod=null;

	@Getter
	@Setter
	private String priceExplainNom="рубль";

	@Getter
	@Setter
	private String priceExplainGen="рубля";

	@Getter
	@Setter
	private TreeSet<Price> priceVariants;
	
    public String getShortPrice() {
		if (getPrice()==null) return "";
		
		Locale locale = new Locale("ru", "RU");      
		NumberFormat currencyFormatter = NumberFormat.getNumberInstance(locale);

		if (getSign()!=null) {
			return getSign()+currencyFormatter.format(getPrice())+" "+getPriceExplainGen();

		}

		return currencyFormatter.format(getPrice())+" "+getPriceExplainGen();

	}

	@Override
	public String toString() {
		return getShortPrice();
	}

	public List<Price> getVariants() {
		return getPriceVariants().stream()
		.filter(price -> price.getParent() == null)
		.collect(Collectors.toList());
	}

	public List<Price> getOptions(Price parent) {
		return getPriceVariants().stream()
		.filter(variant -> StringUtils.equals(parent.getName(),variant.getParent()))
		.collect(Collectors.toList());
	}

	@Override public boolean equals(Object other) {
		if (!(other instanceof Price)) {
		  return false;
		}
		Price otherPriceOption = (Price) other;
		return StringUtils.equals(getParent(), otherPriceOption.getParent()) &&
			StringUtils.equals(getName(), otherPriceOption.getName())
			;
	  }
	
	@Override public int compareTo(Price other) {
	// As of Java 7, this can be replaced with
	// return x != other.x ? Integer.compare(x, other.x) 
	//     : Integer.compare(y, other.y);

	if (getParent()==null && other.getParent()!=null) return -1;

	if (getParent()!=null && other.getParent()==null) return 1;

	if ((getParent()==null && other.getParent()==null)) {

		return getName().compareTo(other.getName());

	};

	if (getParent().compareTo(other.getParent())<0 || (getParent().compareTo(other.getParent())==0 && (getName().compareTo(other.getName())<0))) return -1;

	if (getParent().compareTo(other.getParent())>0 || (getParent().compareTo(other.getParent())==0 && (getName().compareTo(other.getName())>0))) return 1;

	return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getParent(),getName());
	}

	

}
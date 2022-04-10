package thank267.commons.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Passport

{   
    @Getter
    @Setter
    private String seriesPassport;

    @Getter
    @Setter
    private String numberPassport;
    
    @Getter
    @Setter
    private Date dateOfIssued;
   
    @Getter
    @Setter
    private String issuedByWhom;
    
    @Getter
    @Setter
	private String address;

}

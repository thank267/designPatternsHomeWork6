package thank267.commons.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@ToString(onlyExplicitlyIncluded = true)
@Document(collection = "mortgageBank")
public class MortgageBank {

    @Setter
    @Getter
    @Id
    @BsonId
    private String _id;

    @Setter
    @Getter
    @ToString.Include @TextIndexed 
    private String name;

    @Setter
    @Getter
    private BankLicense license;
    
    @Setter
    @Getter
    @TextIndexed 
    private String marketingName;

    @Setter
    @Getter
    @ToString.Include @TextIndexed 
    private Double preference;

    @Setter
    @Getter
    private Binary logo;

}

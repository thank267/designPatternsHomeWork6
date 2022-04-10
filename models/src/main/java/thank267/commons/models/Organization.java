package thank267.commons.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;


public class Organization 
{   

    @Setter
    @Getter
    @BsonId
    private ObjectId _id;

    @BsonProperty("id")
    @Setter
    @Getter
    private Integer id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String fullName;
    
    @Setter
    @Getter
    private String postalAddress;
    
    @Setter
    @Getter
    private String legalAddress;

    @Setter
    @Getter
    private INN inn;

    @Setter
    @Getter
    private String ogrn;
 
    @Setter
    @Getter
    private Bank bank;
    
    @Setter
    @Getter
    private Integer signer;

    @Setter
    @Getter
    private String base;

    @Setter
    @Getter
    private String phone;

}

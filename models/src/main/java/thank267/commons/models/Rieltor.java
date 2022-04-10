package thank267.commons.models;

import java.util.Date;
import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "rieltors")
public class Rieltor 
{   
    @Id
    @Setter
    @Getter
    @BsonId
    @BsonProperty("_id")
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
    private FIO fio;

    @Setter
    @Getter
    private String phone;

    @Setter
    @Getter
    private SEX sex;

    @Setter
    @Getter
    private Date birthday;

    @Setter
    @Getter
    private Binary photo;

    @Setter
    @Getter
    private String email;

    @Getter
    @Setter
    private Passport passport;

    @Setter
    @Getter
    private RieltorStatusEnum status;

    @Getter
	@Setter
	private List<String> roles;

}
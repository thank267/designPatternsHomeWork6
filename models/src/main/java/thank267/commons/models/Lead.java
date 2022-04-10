package thank267.commons.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString(onlyExplicitlyIncluded = true)
@Document(collection = "leads")
public class Lead {

    @Setter
    @Getter
    @Id
    @BsonId
    private String _id;

    @Setter
    @Getter
    private FIO fio;
    
    @Setter
    @Getter
    private String email;

    @Setter
    @Getter
    private Phone phone;

    @Setter
    @Getter
    private String ownerLocation;

    @Setter
    @Getter
    private String address;

    @Getter
	@Setter
	private Integer rieltor;

}

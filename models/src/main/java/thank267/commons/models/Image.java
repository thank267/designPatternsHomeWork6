package thank267.commons.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection="images")
public class Image {
  
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
    private Binary img;
 
}
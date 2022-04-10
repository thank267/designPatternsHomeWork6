package thank267.commons.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "jokes")
public class Joke {

    @Id
    @Setter
    @Getter
    @BsonId
    @BsonProperty("_id")
    private ObjectId _id;
    
    @Setter
    @Getter
    private String text;

    @Setter
    @Getter
    private Binary img;

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return getText();
    }
}

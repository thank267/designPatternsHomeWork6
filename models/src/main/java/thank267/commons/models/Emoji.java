package thank267.commons.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Document(collection = "emojies")
public class Emoji {

    @Setter
    @Getter
    @BsonId
    @Id
    private ObjectId _id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private List<String> codes;

    @Setter
    @Getter
    private Date added;

    @Setter
    @Getter
    private Date retension;

    public Emoji(String name, String codes, Date added, Date retension) {
        this.name = toName(name);
        this.codes = toCodes(codes);
        this.added = added;
        this.retension = retension;
    }

    public String getCodesAsCSV() {
        if (codes == null || codes.size() == 0) return null;

        return String.join(", ", getCodes());

    }

    public String toEmoji() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (String code : codes) {
            final Integer intCode = Integer.decode(code.trim());
            for (Character character : Character.toChars(intCode)) {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    private List<String> toCodes(String text) {
        return Arrays.asList(text.replace("U+", "0x").split(" "));
    }

    private String toName(String text) {
        return text.replace(" ", "_").replace(":", "").replace("-", "_").replace(".", "").replace("&", "_and_").replace("“", "").replace("”", "").replace("’", "_").replace(",_", "_or_").replace("(", "").replace(")", "").replace("#", "hash").replace("*", "asterik").replace("!", "bang").replace("1st", "first").replace("2nd", "second").replace("3rd", "third").replace("⊛_", "").replace("package", "package_box").replaceAll("__", "_").toLowerCase();
    }
}

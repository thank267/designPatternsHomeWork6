package thank267.commons.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class BankLicense {

    @Setter
    @Getter
    private Integer number;

    @Setter
    @Getter
    private Date issued;

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return "Лицензия № "+ String.valueOf(number) + " от " + formatter.format(issued);
    }
    
    
    
}

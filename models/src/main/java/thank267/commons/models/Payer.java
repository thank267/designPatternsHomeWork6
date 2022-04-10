package thank267.commons.models;

import lombok.Getter;
import lombok.Setter;

public class Payer 
{   
    @Setter
    @Getter
    private Organization head;

    @Setter
    @Getter
    private Organization payer;

    @Setter
    @Getter
    private Rieltor signer;
    

}

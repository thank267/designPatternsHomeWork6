package thank267.commons.models;

import lombok.Getter;
import lombok.Setter;

public class Award {

    @Getter
    @Setter
    // вознаграждение по договору
    private Float award;

    @Getter
    @Setter
    // процент вознаграждения по договору
    private Float amountOfCommission;

    @Getter
    @Setter
    // выплата вознаграждения по договору
    private PaymentAward paymentAward;
    
}
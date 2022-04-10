package thank267.commons.models;

import java.util.HashMap;
import java.util.Map;

public enum NotaryPaymentEnum
{   
    Клиент("Клиент"),
    Покупатель("Покупатель"),
    Сторона("Стороной потребовавшей такое нотариальное заверение");

    private final String notary;   // падеж

    NotaryPaymentEnum(String notary) {
        this.notary = notary;
    }

    public String notary() {
        return this.notary;
    }

    private static final Map<String, NotaryPaymentEnum> lookup = new HashMap<>();

    static
    {
        for(NotaryPaymentEnum notary : NotaryPaymentEnum.values())
        {
            lookup.put(notary.notary(), notary);
        }
    }


    //This method can be used for reverse lookup purpose
    public static NotaryPaymentEnum get(String notary) 
    {
        return lookup.get(notary);
    }
}

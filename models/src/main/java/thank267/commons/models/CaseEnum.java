package thank267.commons.models;

import java.util.HashMap;
import java.util.Map;

public enum CaseEnum
{   
    Nom("И"),    // именительный падеж
    Gen("Р"),    // родительный падеж   
    Dat("Д"),    // дательный падеж   
    Acc("В"),    // внительный падеж   
    Ins("Т"),    // творительный падеж   
    Loc("П");    // предложный падеж

    private final String cs;   // падеж

    CaseEnum(String cs) {
        this.cs = cs;
    }

    public String cs() {
        return this.cs;
    }

    private static final Map<String, CaseEnum> lookup = new HashMap<>();

    static
    {
        for(CaseEnum ce : CaseEnum.values())
        {
            lookup.put(ce.cs(), ce);
        }
    }


    //This method can be used for reverse lookup purpose
    public static CaseEnum get(String cs) 
    {
        return lookup.get(cs);
    }

   
    
    public static String toIcu(CaseEnum ce) {

        switch(ce) {
            case Gen:
                return "-genitive";
            case Dat:
                return "-dative";
            case Acc:
                return "-accusative";
            case Ins:
                return "-ablative";   
            case Loc:
                return "-locative";
            default:
                return "";
          }
          

    }

}

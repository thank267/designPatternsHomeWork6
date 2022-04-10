package thank267.commons.models;

import java.util.HashMap;
import java.util.Map;

public enum AttorneyEnum
{   
    With("с правом"),
    Without("без права");
  

    private final String attorney;   // лицо

    AttorneyEnum(String attorney) {
        this.attorney = attorney;
    }

    public String attorney() {
        return this.attorney;
    }

    private static final Map<String, AttorneyEnum> lookup = new HashMap<>();

    static
    {
        for(AttorneyEnum att : AttorneyEnum.values())
        {
            lookup.put(att.attorney(), att);
        }
    }

    //This method can be used for reverse lookup purpose
    public static AttorneyEnum get(String attorney) 
    {
        return lookup.get(attorney);
    }

}

package thank267.commons.models;

import java.util.HashMap;
import java.util.Map;

public enum PersonEnum
{   
    First("1"),
    Second("2"),
    Third("3");

    private final String face;   // лицо

    PersonEnum(String face) {
        this.face = face;
    }

    public String face() {
        return this.face;
    }

    private static final Map<String, PersonEnum> lookup = new HashMap<>();

    static
    {
        for(PersonEnum per : PersonEnum.values())
        {
            lookup.put(per.face(), per);
        }
    }

    //This method can be used for reverse lookup purpose
    public static PersonEnum get(String face) 
    {
        return lookup.get(face);
    }

}

package thank267.commons.models;

public enum GenderEnum
{   
    Masc,
    Fem,
    Neut,
    Com;

    public static String toIcu(GenderEnum ge) {

        switch(ge) {
            case Masc:
                return "-masculine";
            case Fem:
                return "-feminine";
            default:
                return "-neuter";
          }
          

    }

    public static String toIcu(String ge) {

        switch(ge) {
            case "Masc":
                return "-masculine";
            case "Fem":
                return "-feminine";
            default:
                return "-neuter";
          }
          

    }
}

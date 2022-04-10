package thank267.commons.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Person 
{   
    @Setter
    @Getter
    private Integer id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private FIO fio;

    @Setter
    @Getter
    private String email;

    @Setter
    @Getter
    private Phone phone;

    @Setter
    @Getter
    private SEX sex;

    @Setter
    @Getter
    private Date birthday;

    @Setter
    @Getter
    private Passport passport;

    @Setter
    @Getter
    private String ownership;

}
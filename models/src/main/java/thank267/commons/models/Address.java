package thank267.commons.models;

import lombok.Getter;
import lombok.Setter;

public class Address {

    @Getter
    @Setter
    // адрес
    private String address;

    @Getter
    @Setter
    // индекс
    private String index;

    @Getter
    @Setter
    // Тип области
    private String oblast_type;

    @Getter
    @Setter
    // Область
    private String oblast;

    @Getter
    @Setter
    // Тип города
    private String city_type;

    @Getter
    @Setter
    // Город
    private String city;

    @Getter
    @Setter
    // микрорайон
    private String suburb;

    @Getter
    @Setter
    // Тип улицы
    private String street_type;

    @Getter
    @Setter
    // улица
    private String street;

    @Getter
    @Setter
    // тип номера дома
    private String house_type;

    @Getter
    @Setter
    // номер дома
    private String house;

    @Getter
    @Setter
    // тип блока
    private String block_type;

    @Getter
    @Setter
    // блок
    private String block;

    @Getter
    @Setter
    // сленг
    private String speech;

    @Override
    public String toString() {
        
        return getAddress();
    }

}
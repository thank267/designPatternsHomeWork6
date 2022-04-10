package thank267.commons.models;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

import lombok.Getter;
import lombok.Setter;

public class Phone {

    @Setter
    @Getter
    int country_code = 0;

    @Setter
    @Getter
    long nationalNumber = 0L;

    @Override
    public String toString() {

        if (country_code == 0 || nationalNumber == 0L)
            return "+7 (___) ___-__-__";
        else {

            PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

            return phoneUtil.format(
                new PhoneNumber().setCountryCode(country_code).setNationalNumber(nationalNumber),
                
                PhoneNumberFormat.NATIONAL
            );

            
        }

		
	}
    
}
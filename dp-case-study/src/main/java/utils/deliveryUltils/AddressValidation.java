package utils.deliveryUltils;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressValidation implements InfoValidation {
    public boolean validate(String address) {
        if (Objects.isNull(address))
            return false;
        String patternString = "^[a-zA-Z\\s]*$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }
}

package utils.deliveryUltils;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidation implements InfoValidation {
    public boolean validate(String name) {
        if (Objects.isNull(name))
            return false;
        String patternString = "^[a-zA-Z\\s]*$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}

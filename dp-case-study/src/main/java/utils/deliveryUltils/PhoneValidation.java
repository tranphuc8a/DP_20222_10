package utils.deliveryUltils;

public class PhoneValidation implements InfoValidation {
    public boolean validate(String phoneNumber) {
        if (phoneNumber.length() != 10)
            return false;
        if (!phoneNumber.startsWith("0"))
            return false;
        try {
            Integer.parseInt(phoneNumber);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

package utils.currency;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatting {
    public static String getCurrencyFormat(int num) {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(vietnam);
        return defaultFormat.format(num);
    }
}

package views.screen;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author
 */
public class ViewsConfig {

    //Violate SRP: Should seperate function into difference module: TaxConfig, FontConfig,...
    //Logical cohesion: tất cả các thuộc tính về PATH
    //solution: có thể tách vào 1 class PathConfig
    // static resource
    public static final String IMAGE_PATH = "src/main/resources/assets/images";
    public static final String INVOICE_SCREEN_PATH = "/views/fxml/invoice.fxml";
    public static final String INVOICE_MEDIA_SCREEN_PATH = "/views/fxml/media_invoice.fxml";
    public static final String PAYMENT_SCREEN_PATH = "/views/fxml/payment.fxml";
    public static final String RESULT_SCREEN_PATH = "/views/fxml/result.fxml";
    public static final String LOGIN_SCREEN_PATH = "/views/fxml/login.fxml";
    public static final String INTRO_SCREEN_PATH = "/views/fxml/intro.fxml";
    public static final String CART_SCREEN_PATH = "/views/fxml/cart.fxml";
    public static final String SHIPPING_SCREEN_PATH = "/views/fxml/shipping.fxml";
    public static final String CART_MEDIA_PATH = "/views/fxml/media_cart.fxml";
    public static final String HOME_PATH  = "/views/fxml/home.fxml";
    public static final String HOME_MEDIA_PATH = "/views/fxml/media_home.fxml";
    public static final String POPUP_PATH = "/views/fxml/popup.fxml";

    //Logical cohesion: PERCENT_VAT
    //solution: có thể tách vào 1 class TaxConfig
    public static float PERCENT_VAT = 10;

    //Logical cohesion: REGULAR_FONT
    //solution: có thể tách vào 1 class FontConfig
    public static Font REGULAR_FONT = Font.font("Segoe UI", FontWeight.NORMAL, FontPosture.REGULAR, 24);

    //Logical cohesion: getCurrencyFormat()
    //solution: có thể tách vào 1 class CurrencyFormatUtil
    public static String getCurrencyFormat(int num) {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(vietnam);
        return defaultFormat.format(num);
    }
}

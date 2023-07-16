package views.screen.config;

/**
 * @author
 */
public class ViewPathsConfig {

    // SRP: các nhóm trách nhiệm khác nhau cùng chung 1 lớp: path, VAT, font, currency
    // Solution: Tách thành 4 lớp như solution của coincidental cohesion

    //coincidental cohesion: tất cả các thuộc tính về PATH
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
}

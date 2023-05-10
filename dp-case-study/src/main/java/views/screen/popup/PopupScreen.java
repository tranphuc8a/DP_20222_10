package views.screen.popup;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;

import java.io.IOException;


public class PopupScreen extends BaseScreenHandler {
    /*
    Logical cohesion: success(), error(), loading()
    Solution:
        - Trong lớp PopupScreen: thêm phương thức showPopup() để các lớp extension mở rộng,
            chuyển popup() từ private static -> protected
        - Tạo 3 lớp con SuccessPopupScreen, ErrorPopupScreen, LoadingPopupScreen extends PopupScreen,
            trong mỗi lớp này cần override method showPopup() và triển khai các method tương ứng với
            success(), error(), loading() ở dưới
        - 3 lớp con trên có thể triển khai singleton pattern vì chỉ cần sử dụng 1 object duy nhất để
            những công việc này
     */

    /*
    SRP: 3 hàm success, error, loading có 3 trách nhiệm khác nhau
    OCP: Lớp đóng cho việc mở rộng các chức năng pop kiểu khác
    Solution: Như solution của cohesion

    */
    
    @FXML
    ImageView icon;

    @FXML
    Label message;

    public PopupScreen(Stage stage) throws IOException{
        super(stage, ViewsConfig.POPUP_PATH);
    }

    private static PopupScreen popup(String message, String imagePath, Boolean undecorated) throws IOException{
        PopupScreen popup = new PopupScreen(new Stage());
        if (undecorated) popup.stage.initStyle(StageStyle.UNDECORATED);
        popup.message.setText(message);
        popup.setImage(imagePath);
        return popup;
    }

    public static void success(String message) throws IOException{
        popup(message, ViewsConfig.IMAGE_PATH + "/" + "tickgreen.png", true)
                .show(true);
    }

    public static void error(String message) throws IOException{
        popup(message, ViewsConfig.IMAGE_PATH + "/" + "tickerror.png", false)
                .show(false);
    }

    public static PopupScreen loading(String message) throws IOException{
        return popup(message, ViewsConfig.IMAGE_PATH + "/" + "loading.gif", true);
    }

    public void setImage(String path) {
        super.setImage(icon, path);
    }

    public void show(Boolean autoClose) {
        super.show();
        if (autoClose) close(0.8);
    }

    public void show(double time) {
        super.show();
        close(time);
    }

    public void close(double time) {
        PauseTransition delay = new PauseTransition(Duration.seconds(time));
        delay.setOnFinished( event -> stage.close() );
        delay.play();
    }

    protected void setupData(Object dto) throws Exception { // chưa thực hiện
    }

    protected void setupFunctionality() throws Exception { // chưa thực hiện
    }
}

package views.screen.popup;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import views.screen.ViewsConfig;

import java.io.IOException;

public class SuccessPopupScreen extends PopupScreen{
    private static SuccessPopupScreen instance;

    public static SuccessPopupScreen getInstance() throws IOException {
        if (instance == null) {
            instance = new SuccessPopupScreen(new Stage());
        }
        return instance;
    }
    public SuccessPopupScreen(Stage stage) throws IOException {
        super(stage);
    }

    @Override
    protected SuccessPopupScreen createPopup(String message) throws IOException {
        SuccessPopupScreen popup = new SuccessPopupScreen(new Stage());
        popup.stage.initStyle(StageStyle.UNDECORATED);
        popup.message.setText(message);
        popup.setImage(ViewsConfig.IMAGE_PATH + "/" + "tickgreen.png");
        return popup;
    }

    @Override
    public void showPopup(String message) throws Exception {
        SuccessPopupScreen popup = createPopup(message);
        popup.show(true);
    }
}

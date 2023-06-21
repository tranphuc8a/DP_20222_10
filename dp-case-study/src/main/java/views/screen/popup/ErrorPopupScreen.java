package views.screen.popup;

import javafx.stage.Stage;
import views.screen.ViewsConfig;

import java.io.IOException;

public class ErrorPopupScreen extends PopupScreen{
    private static ErrorPopupScreen instance;

    public static ErrorPopupScreen getInstance() throws IOException {
        if (instance == null) {
            instance = new ErrorPopupScreen(new Stage());
        }
        return instance;
    }

    public ErrorPopupScreen(Stage stage) throws IOException {
        super(stage);
    }

    @Override
    protected ErrorPopupScreen createPopup(String message) throws IOException {
        ErrorPopupScreen popup = new ErrorPopupScreen(new Stage());
//        if (undecorated) popup.stage.initStyle(StageStyle.UNDECORATED);
        popup.message.setText(message);
        popup.setImage(ViewsConfig.IMAGE_PATH + "/" + "tickerror.png");
        return popup;
    }

    @Override
    public void showPopup(String message) throws IOException {
        ErrorPopupScreen popup = createPopup(message);
        popup.show(false);
    }
}

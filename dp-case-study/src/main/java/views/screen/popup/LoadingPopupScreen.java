package views.screen.popup;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import views.screen.ViewsConfig;

import java.io.IOException;

public class LoadingPopupScreen extends PopupScreen{
    private static LoadingPopupScreen instance;

    public static LoadingPopupScreen getInstance() throws IOException {
        if (instance == null) {
            instance = new LoadingPopupScreen(new Stage());
        }
        return instance;
    }
    public LoadingPopupScreen(Stage stage) throws IOException {
        super(stage);
    }

    @Override
    protected LoadingPopupScreen createPopup(String message) throws IOException {
        LoadingPopupScreen popup = new LoadingPopupScreen(new Stage());
        popup.stage.initStyle(StageStyle.UNDECORATED);
        popup.message.setText(message);
        popup.setImage(ViewsConfig.IMAGE_PATH + "/" + "loading.gif");
        return popup;
    }

    @Override
    public void showPopup(String message) throws Exception {
        LoadingPopupScreen popup = createPopup(message);
        popup.show(true);
    }
}

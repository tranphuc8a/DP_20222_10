package views.screen.home;

import controller.AuthenticationController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.popup.ErrorPopupScreen;
import views.screen.popup.SuccessPopupScreen;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

//temporal cohesion: ở các hàm setupData() và setupFunctionality()
public class LoginScreenHandler extends BaseScreenHandler{
    public static Logger LOGGER = Utils.getLogger(LoginScreenHandler.class.getName());

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    public LoginScreenHandler(Stage stage, String screenPath) throws IOException{
        super(stage, screenPath);
        try {
            setupData(null);
            setupFunctionality();
        } catch (IOException ex) {
            LOGGER.info(ex.getMessage());
//            PopupScreen.error("Error when loading resources.");
            ErrorPopupScreen.getInstance().showPopup("Error when loading resources.");
        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
//            PopupScreen.error(ex.getMessage());
            ErrorPopupScreen.getInstance().showPopup(ex.getMessage());
        }
    }

    public AuthenticationController getBController() {
        return (AuthenticationController) super.getBController();
    }

    protected void setupData(Object dto) throws Exception { // hàm này chưa hoàn thiện
    }

    protected void setupFunctionality() throws Exception {
    }

    @FXML
    void login(MouseEvent event) throws IOException, InterruptedException, SQLException {
        try {
            getBController().login(email.getText(), password.getText());
//            PopupScreen.success("Login Successfully!");
            SuccessPopupScreen.getInstance().showPopup("Login Successfully!");
            backToHomeScreen(event);
        } catch (Exception ex) {
//            PopupScreen.error(ex.getMessage());
            ErrorPopupScreen.getInstance().showPopup(ex.getMessage());
        }
    }

    @FXML
    void backToHomeScreen(MouseEvent event) throws IOException, InterruptedException, SQLException {
        // biến event vi phạm stamp coupling vì không được sử dụng
        this.homeScreenHandler.show();
    }
}

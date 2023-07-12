package views.screen.payment;

import entity.invoice.Invoice;
import entity.payment.MomoWallet;
import entity.payment.PaymentMethod;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.popup.ErrorPopupScreen;

import java.io.IOException;
import java.util.logging.Logger;

public class MomoWalletPaymentScreenHandler extends WalletPaymentScreenHandler {
    private static final Logger LOGGER = Utils.getLogger(MomoWalletPaymentScreenHandler.class.getName());

    @FXML
    private Button btnConfirmPayment;

    @FXML
    private ImageView loadingImage;

    @FXML
    private Label pageTitle;

    @FXML
    private TextField accountNumber;

    @FXML
    private TextField holderName;

    @FXML
    private TextField branch;

    public MomoWalletPaymentScreenHandler(Stage stage, String screenPath, Invoice invoice) throws IOException {
        super(stage, screenPath, invoice);
        try {
            setupFunctionality();
        } catch (IOException ex) {
            LOGGER.info(ex.getMessage());
            ErrorPopupScreen.getInstance().showPopup("Error when loading resources.");
        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
            ErrorPopupScreen.getInstance().showPopup(ex.getMessage());
        }
    }

    @Override
    protected PaymentMethod getWalletPaymentMethod() {
        return new MomoWallet(accountNumber.getText(),
                holderName.getText(),
                branch.getText());
    }

    protected void setupFunctionality() throws Exception {
        // temporily do nothing
    }
}

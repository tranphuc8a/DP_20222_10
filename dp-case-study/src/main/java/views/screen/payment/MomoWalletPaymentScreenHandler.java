package views.screen.payment;

import entity.invoice.Invoice;
import entity.payment.MomoWallet;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.popup.ErrorPopupScreen;

import java.io.IOException;
import java.util.logging.Logger;

public class MomoWalletPaymentScreenHandler extends PaymentScreenHandler {
    private static final Logger LOGGER = Utils.getLogger(MomoWalletPaymentScreenHandler.class.getName());

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
    protected MomoWallet getPaymentMethod() {
        return new MomoWallet("Default owner", "00000000", "Default branch");
    }

    protected void setupFunctionality() throws Exception {
        // temporily do nothing
    }
}

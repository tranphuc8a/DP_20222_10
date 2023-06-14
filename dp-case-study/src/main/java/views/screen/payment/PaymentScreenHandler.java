package views.screen.payment;

import controller.PaymentController;
import entity.invoice.Invoice;
import entity.payment.PaymentMethod;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;
import views.screen.popup.ErrorPopupScreen;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

abstract public class PaymentScreenHandler extends BaseScreenHandler {
    private static final Logger LOGGER = Utils.getLogger(PaymentScreenHandler.class.getName());
    protected Invoice invoice;
    protected PaymentScreenHandler(Stage stage, String screenPath, Invoice invoice) throws IOException {
        super(stage, screenPath);
        try {
            setupData(invoice);
        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
            ErrorPopupScreen.getInstance().showPopup(ex.getMessage());
        }

    }

    protected void setupData(Object dto) {
        this.invoice = (Invoice) dto;
    }

    protected abstract PaymentMethod getPaymentMethod();

    protected void confirmToPayOrder() throws IOException{
        String contents = "pay order";
        PaymentController ctrl = (PaymentController) getBController();
//        Map<String, String> response = ctrl.payOrder(invoice.getAmount(), contents, cardNumber.getText(), holderName.getText(),
//                expirationDate.getText(), securityCode.getText());
        Map<String, String> response = ctrl.payOrder(invoice.getAmount(), contents, getPaymentMethod());

        BaseScreenHandler resultScreen = new ResultScreenHandler(this.stage, ViewsConfig.RESULT_SCREEN_PATH, response);
        resultScreen.setPreviousScreen(this);
        resultScreen.setHomeScreenHandler(homeScreenHandler);
        resultScreen.setScreenTitle("Result Screen");
        resultScreen.show();
    }
}

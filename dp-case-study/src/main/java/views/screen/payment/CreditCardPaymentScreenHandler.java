package views.screen.payment;

import controller.PaymentController;
import entity.invoice.Invoice;
import entity.payment.CreditCard;
import entity.payment.PaymentMethod;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;
import views.screen.popup.ErrorPopupScreen;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

//temporal cohesion: ở các hàm setupData() và setupFunctionality()
public class CreditCardPaymentScreenHandler extends CardPaymentScreenHandler {
	private static final Logger LOGGER = Utils.getLogger(CreditCardPaymentScreenHandler.class.getName());

	@FXML
	private Button btnConfirmPayment;

	@FXML
	private ImageView loadingImage;

	@FXML
	private Label pageTitle;

	@FXML
	private TextField cardNumber;

	@FXML
	private TextField issuingBank;

	@FXML
	private TextField holderName;
	
	@FXML
	private TextField expirationDate;

	@FXML
	private TextField securityCode;

	public CreditCardPaymentScreenHandler(Stage stage, String screenPath, Invoice invoice) throws IOException {
		super(stage, screenPath, invoice);
		try {
			setupFunctionality();
		} catch (IOException ex) {
			LOGGER.info(ex.getMessage());
			// PopupScreen.error("Error when loading resources.");
			ErrorPopupScreen.getInstance().showPopup("Error when loading resources.");
		} catch (Exception ex) {
			LOGGER.info(ex.getMessage());
			// PopupScreen.error(ex.getMessage());
			ErrorPopupScreen.getInstance().showPopup(ex.getMessage());
		}
	}

	@Override
	protected CreditCard getPaymentMethod() {
		return new CreditCard(
				cardNumber.getText(),
				issuingBank.getText(),
				holderName.getText(),
				((PaymentController) getBController()).getExpirationDate(expirationDate.getText()),
				Integer.parseInt(securityCode.getText()));
	}

	protected void setupFunctionality() throws Exception {
		btnConfirmPayment.setOnMouseClicked(e -> {
			try {
				confirmToPayOrder();
				((PaymentController) getBController()).emptyCart();
			} catch (Exception exp) {
				System.out.println(exp.getStackTrace());
			}
		});
	}

}
package subsystem.interbank;

import entity.payment.PaymentTransaction;
import entity.payment.PaymentTransaction;

public class InterbankSubsystemController {
	// Functional cohesion
	// singleton: use private static final
	private static InterbankPayloadConverter interbankPayloadConverter = new InterbankPayloadConverter();
	private static InterbankBoundary interbankBoundary = new InterbankBoundary();

	public PaymentTransaction refund(PaymentTransaction paymentTransaction, int amount, String contents) {
		return null;
	} // hiện chưa làm gì

	public PaymentTransaction payOrder(PaymentTransaction paymentTransaction, int amount, String contents) {
		String requestPayload = interbankPayloadConverter.convertToRequestPayload(paymentTransaction, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
	}

}

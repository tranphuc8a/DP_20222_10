package subsystem.interbank;

import entity.payment.Card;
import entity.payment.PaymentMethod;
import entity.payment.PaymentTransaction;

public class InterbankSubsystemController {
	private static InterbankPayloadConverter interbankPayloadConverter = new InterbankPayloadConverter();
	private static InterbankBoundary interbankBoundary = new InterbankBoundary();

	public PaymentTransaction refund(PaymentMethod paymentMethod, int amount, String contents) {
		return null;
	} // hiện chưa làm gì

	public PaymentTransaction payOrder(PaymentMethod paymentMethod, int amount, String contents) {
		String requestPayload = interbankPayloadConverter.convertToRequestPayload(paymentMethod, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
	}

}

package subsystem.interbank;

import entity.payment.Card;
import entity.payment.PaymentTransaction;

public class InterbankSubsystemController {
	private static InterbankPayloadConverter interbankPayloadConverter = new InterbankPayloadConverter();
	private static InterbankBoundary interbankBoundary = new InterbankBoundary();

	public PaymentTransaction refund(Card card, int amount, String contents) {
		return null;
	} // hiện chưa làm gì

	public PaymentTransaction payOrder(Card card, int amount, String contents) {
		String requestPayload = interbankPayloadConverter.convertToRequestPayload(card, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
	}

}

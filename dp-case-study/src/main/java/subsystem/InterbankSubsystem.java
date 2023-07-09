package subsystem;

import entity.payment.PaymentTransaction;
import subsystem.interbank.InterbankSubsystemController;

/***
 * The {@code InterbankSubsystem} class is used to communicate with the
 * Interbank to make transaction.
 * 
 * @author hieud
 *
 */
public class InterbankSubsystem implements InterbankInterface {
	/**
	 * Represent the controller of the subsystem
	 * singleton
	 */
	private InterbankSubsystemController ctrl;

	/**
	 * Initializes a newly created {@code InterbankSubsystem} object so that it
	 * represents an Interbank subsystem.
	 */
	public InterbankSubsystem() {
		this.ctrl = new InterbankSubsystemController();
	}

	/**
	 * @see InterbankInterface#payOrder(entity.payment.PaymentTransaction, int,
	 *      String)
	 */
	public PaymentTransaction payOrder(PaymentTransaction paymentTransaction, int amount, String contents) {
		PaymentTransaction transaction = ctrl.payOrder(paymentTransaction, amount, contents);
		return transaction;
	}

	/**
	 * @see InterbankInterface#refund(Card, int,
	 *      String)
	 */
	public PaymentTransaction refund(PaymentTransaction paymentTransaction, int amount, String contents) {
		PaymentTransaction transaction = ctrl.refund(paymentTransaction, amount, contents);
		return transaction;
	}
}

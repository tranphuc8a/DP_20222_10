package subsystem;

import entity.payment.Card;
import entity.payment.PaymentMethod;
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
	 * @see InterbankInterface#payOrder(entity.payment.PaymentMethod, int,
	 *      String)
	 */
	public PaymentTransaction payOrder(PaymentMethod paymentMethod, int amount, String contents) {
		PaymentTransaction transaction = ctrl.payOrder(paymentMethod, amount, contents);
		return transaction;
	}

	/**
	 * @see InterbankInterface#refund(PaymentMethod, int,
	 *      String)
	 */
	public PaymentTransaction refund(PaymentMethod paymentMethod, int amount, String contents) {
		PaymentTransaction transaction = ctrl.refund(paymentMethod, amount, contents);
		return transaction;
	}
}

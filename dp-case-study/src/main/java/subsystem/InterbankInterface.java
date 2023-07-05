package subsystem;

import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.payment.PaymentMethod;
import entity.payment.PaymentTransaction;

/**
 * The {@code InterbankInterface} class is used to communicate with the
 * {@link InterbankSubsystem InterbankSubsystem} to make transaction
 * 
 * @author hieud
 * 
 */
public interface InterbankInterface {

	/**
	 * Pay order, and then return the payment transaction
	 * 
	 * @param paymentMethod     - the payment method used for payment
	 * @param amount   - the amount to pay
	 * @param contents - the transaction contents
	 * @return {@link PaymentTransaction PaymentTransaction} - if the
	 *         payment is successful
	 * @throws PaymentException      if responded with a pre-defined error code
	 * @throws UnrecognizedException if responded with an unknown error code or
	 *                               something goes wrong
	 */
	public abstract PaymentTransaction payOrder(PaymentMethod paymentMethod, int amount, String contents)
			throws PaymentException, UnrecognizedException;

	/**
	 * Refund, and then return the payment transaction
	 * 
	 * @param paymentMethod     - the payment method which would be refunded to
	 * @param amount   - the amount to refund
	 * @param contents - the transaction contents
	 * @return {@link PaymentTransaction PaymentTransaction} - if the
	 *         payment is successful
	 * @throws PaymentException      if responded with a pre-defined error code
	 * @throws UnrecognizedException if responded with an unknown error code or
	 *                               something goes wrong
	 */
	public abstract PaymentTransaction refund(PaymentMethod paymentMethod, int amount, String contents)
			throws PaymentException, UnrecognizedException;

}

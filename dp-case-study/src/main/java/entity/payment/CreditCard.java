package entity.payment;

/**
 * @author
 */
public class CreditCard {
    // OCP: being used by: PaymentController,
    // PaymentTransaction, InterbankPayloadConverter, so it hard to change

    private String cardCode;
    private String owner;
    private String dateExpired;
    protected int cvvCode;

    public CreditCard(String cardCode, String owner, String dateExpired, int cvvCode) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }
}

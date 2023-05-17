package entity.payment;

/**
 * @author
 */
public class CreditCard {
    // OCP: các lớp sau sử dụng CreditCard có thể vi phạm: PaymentController, PaymentTransaction, InterbankPayloadConverter

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

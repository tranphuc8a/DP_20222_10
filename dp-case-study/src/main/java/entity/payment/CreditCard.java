package entity.payment;

/**
 * @author
 */
public class CreditCard extends Card{
    // DIP: các lớp sau sử dụng CreditCard có thể vi phạm: PaymentController, PaymentTransaction, InterbankPayloadConverter, InterbankInterface

    public CreditCard(String cardCode, String issuingBank, String owner, String dateExpired, int cvvCode) {
        super(cardCode, issuingBank, owner, dateExpired, cvvCode);
    }
}

package entity.payment;

public class Card extends PaymentMethod{
    protected String cardCode;
    protected String dateExpired;
    protected int cvvCode;

    public Card(String cardCode, String owner, String dateExpired, int cvvCode) {
        super(owner);
        this.cardCode = cardCode;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getDateExprired() {
        return this.dateExpired;
    }

    public Number getCvvCode() {
        return this.cvvCode;
    }
}

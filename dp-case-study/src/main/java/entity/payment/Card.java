package entity.payment;

import subsystem.InterbankInterface;
import subsystem.InterbankSubsystem;

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

    @Override
    public void pay(int amount, String contents) {
        InterbankInterface interbank = new InterbankSubsystem();
        PaymentTransaction transaction = interbank.payOrder(this, amount, contents);
    }
}

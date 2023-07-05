package entity.payment;

import subsystem.InterbankInterface;
import subsystem.InterbankSubsystem;

public abstract class PaymentMethod {
    protected String owner;

    public PaymentMethod(String owner) {
        this.owner = owner;
    }

//    public void pay(int amount, String contents) {
//        InterbankInterface interbank = new InterbankSubsystem();
//        PaymentTransaction transaction = interbank.payOrder(this, amount, contents);
//    }

    public abstract void pay(int amount, String contents);

}

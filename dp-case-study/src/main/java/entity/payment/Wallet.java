package entity.payment;

public class Wallet extends PaymentMethod{
    protected String accountNumber;
    protected String branch;

    public Wallet(String owner, String accountNumber, String branch) {
        super(owner);
        this.accountNumber = accountNumber;
        this.branch = branch;
    }
}

package entity.payment;

public class Wallet extends PaymentMethod{
    protected String accountNumber;
    protected String branch;

    public Wallet(String owner, String accountNumber, String branch) {
        super(owner);
        this.accountNumber = accountNumber;
        this.branch = branch;
    }

        public String getOwner() {
        return this.owner;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getBranch() {
        return this.branch;
    }
}

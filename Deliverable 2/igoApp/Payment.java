package resources;

public class Payment {
    private float amount;
    private String transactionID;
    private String paymentType;
    private float balance;

    public void setPayment(float amount) {
        this.amount = amount;
        this.balance += amount;
        // Generate a unique transaction ID
        this.transactionID = UUID.randomUUID().toString();
    }

    public float getBalanceAmount() {
        return this.balance;
    }

    public boolean isPaymentSuccessful() {
        return true; // Payment is always successful in this implementation
    }

    public double checkBalance(double cashAmount) {
        if (this.balance >= cashAmount) {
            this.balance -= cashAmount;
            return cashAmount;
        } else {
            return -1; // Insufficient balance
        }
    }

    public String getTransactionCode() {
        return this.transactionID;
    }
}

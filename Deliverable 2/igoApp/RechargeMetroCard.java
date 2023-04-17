package resources;


public class RechargeMetroCard {
    private int cardNumber;
    private double rechargeAmount;
    private String passType;
    private double balance;

    public RechargeMetroCard(int cardNumber, double rechargeAmount, String passType) {
        this.cardNumber = cardNumber;
        this.rechargeAmount = rechargeAmount;
        this.passType = passType;
        this.balance = 0;
    }

    public void rechargeType() {
        System.out.println("Pass Type: " + this.passType);
    }

    public void rechargeStatus() {
        System.out.println("Recharge amount: " + this.rechargeAmount);
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public void payment() {
        if (this.rechargeAmount <= this.balance) {
            System.out.println("Payment successful.");
            this.balance -= this.rechargeAmount;
        } else {
            System.out.println("Payment failed due to insufficient balance.");
        }
    }
}

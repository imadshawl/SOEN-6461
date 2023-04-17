package resources;

public class PaymentGateway {
    private String paymentType;
    private String paymentAmount;
    private double cashAmount;
    private String creditCardNumber;
    private String creditCardExpiry;
    private int cvvNumber;

    public PaymentGateway(String paymentType, String paymentAmount) {
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
    }

    public void processPayment() {
        if (paymentType.equalsIgnoreCase("cash")) {
            double balance = checkBalance(cashAmount);
            if (balance >= Double.parseDouble(paymentAmount)) {
                System.out.println("Payment successful. Please collect your ticket.");
            } else {
                System.out.println("Insufficient cash balance. Please try again with another payment method.");
            }
        } else if (paymentType.equalsIgnoreCase("credit")) {
            if (validateCardDetails(creditCardNumber, creditCardExpiry, cvvNumber)) {
                verifyPayment();
            } else {
                System.out.println("Invalid card details. Please try again with correct card details.");
            }
        }
    }

    public boolean validateCardDetails(String creditCardNumber, String creditCardExpiry, int cvvNumber) {
        // logic to validate credit card details goes here
        return true; // replace with actual validation logic
    }

    public void verifyPayment() {
        // logic to verify payment goes here
        System.out.println("Payment verified. Please collect your ticket.");
    }

    public double checkBalance(double cashAmount) {
        // logic to check balance goes here
        return 1000.0; // replace with actual balance checking logic
    }

    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setCreditCardExpiry(String creditCardExpiry) {
        this.creditCardExpiry = creditCardExpiry;
    }

    public void setCvvNumber(int cvvNumber) {
        this.cvvNumber = cvvNumber;
    }
}

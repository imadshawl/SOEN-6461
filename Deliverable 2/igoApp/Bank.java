package resources;

public class Bank {
    private String creditCardNumber;
    private int cvvNumber;
    private double transactionAmount;
    private String transactionID;

    public void searchAccountDetails(String creditCardNumber) {
        // Code to search account details for given credit card number
    }

    public void authenticatePayment() {
        // Code to authenticate payment for the transaction
    }

    public boolean verifyPayment() {
        return false;
        // Code to verify if the payment was successful or not
        // Returns true if payment was successful, false otherwise
    }
}


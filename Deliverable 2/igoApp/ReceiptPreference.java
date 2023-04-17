package resources;

public class ReceiptPreference {
    private boolean isPaper;
    private String email;
    private String date;
    private String time;
    private float price;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPaperBased() {
        return isPaper;
    }

    public void setPaperBased(boolean isPaper) {
        this.isPaper = isPaper;
    }

    public void generateReceipt(Payment payment) {
        // Generate receipt based on preference
        if (isPaper) {
            System.out.println("Generating paper receipt...");
            System.out.println("Date: " + date);
            System.out.println("Time: " + time);
            System.out.println("Price: " + price);
            System.out.println("Transaction ID: " + payment.getTransactionCode());
        } else {
            System.out.println("Sending email receipt to " + email + "...");
            System.out.println("Date: " + date);
            System.out.println("Time: " + time);
            System.out.println("Price: " + price);
            System.out.println("Transaction ID: " + payment.getTransactionCode());
        }
    }
}


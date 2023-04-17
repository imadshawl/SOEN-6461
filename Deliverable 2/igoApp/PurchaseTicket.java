package resources;

public class PurchaseTicket {
    private int ticketNumber;
    private String ticketType;
    private double ticketPrice;

    public PurchaseTicket(int ticketNumber, String ticketType, double ticketPrice) {
        this.ticketNumber = ticketNumber;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void issueTicket() {
        // Code to issue ticket to user
        System.out.println("Ticket issued successfully!");
    }

    public void payment() {
        // Code to process payment for ticket
        System.out.println("Payment processed successfully!");
    }
}

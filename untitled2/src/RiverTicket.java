public class RiverTicket extends ticket{
    public RiverTicket(String TicketName, double TicketPrice) {
        super(TicketName, TicketPrice);
    }
    public static double TicketPrice(int Amount){
        return 20.00;
    }
}

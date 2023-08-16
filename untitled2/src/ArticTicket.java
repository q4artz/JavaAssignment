public class ArticTicket extends ticket{
   // int Amount;
    public ArticTicket(String TicketName, double TicketPrice) {

        super(TicketName, TicketPrice);
    }
    public static double TicketPrice(int Amount){
        return 50.00;
    }
}

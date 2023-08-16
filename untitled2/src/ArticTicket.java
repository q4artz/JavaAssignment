public class ArticTicket extends ticket{
   // int Amount;
    public ArticTicket(String TicketName, double TicketPrice) {

        super(TicketName, TicketPrice);
    }
    public static double TicketPrice(int Amount){
        double TicketPrice = 50.00;
        double Discount=0.00;
        if(Amount >= 5 && Amount <= 6){
            System.out.println("[+] You Will Get a 5% Discount for purchasing more than 2!");
            Discount = (TicketPrice*5)/100;
        }
        else if(Amount > 6){
            System.out.println("[+] You will get a 10% Discount for purchasing more than 5!");
            Discount = (TicketPrice*10)/100;
        }
        TicketPrice = TicketPrice-Discount;
        System.out.printf("[+] The total Artic Ticket Price is %.2f ",TicketPrice);
        return TicketPrice;
    }
}

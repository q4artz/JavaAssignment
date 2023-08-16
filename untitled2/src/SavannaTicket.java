public class SavannaTicket extends ticket{
    //int Amount;
    public SavannaTicket(String TicketName, double TicketPrice) {
        super(TicketName, TicketPrice);
    }
    public static double TicketPrice(int Amount){
        double TicketPrice = 20.00;
        double Discount=0.00;
        if(Amount >= 5 && Amount <= 10){
            System.out.println("[+] You Will Get a 2% Discount for purchasing more than 2!");
            Discount = (TicketPrice*2)/100;
        }
        else if(Amount > 10){
            System.out.println("[+] You will get a 5% Discount for purchasing more than 5!");
            Discount = (TicketPrice*5)/100;
        }
        TicketPrice = TicketPrice-Discount;
        System.out.printf("[+] The total Savanna Ticket Price is %.2f ",TicketPrice);
        return TicketPrice;
    }



}
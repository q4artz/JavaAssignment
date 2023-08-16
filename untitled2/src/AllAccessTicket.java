public abstract class AllAccessTicket extends ticket{
    //int Amount;
    public AllAccessTicket(String TicketName, double TicketPrice) {
        super(TicketName, TicketPrice);
    }
    public static double TicketPrice(int Amount){
        double TicketPrice = 80.00;
        double Discount=0.00;
        if(Amount >= 2 && Amount <= 5){
            System.out.println("[+] You Will Get a 5% Discount for purchasing more than 2!");
            Discount = (TicketPrice*5)/100;
        }
        else if(Amount > 5){
            System.out.println("[+] You will get a 8% Discount for purchasing more than 5!");
                Discount = (TicketPrice*8)/100;
            }
        TicketPrice = TicketPrice-Discount;
        System.out.printf("[+] The total All Access Ticket Price is %.2f ",TicketPrice);
        return TicketPrice;
    }
}

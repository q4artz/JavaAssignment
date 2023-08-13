import java.util.Random;
// This class is a PARENT class for 4 of the ticket options
public class ticket {

    // This Variable is used here to declear the Ticket name
    // They will be pass to their respective Class at the end of this Fucntion
    String TicketName;
    double TicketPrice;
    int Amount;

    public ticket(String TicketName, double TicketPrice){
        this.TicketName = TicketName;
        this.TicketPrice = TicketPrice;
    }

    // This Function is used to
    // 1. Get the ticket wanted from User input from Main
    // 2. Generate a unique Ticket Code
    public String TicketGenerate(String username,String TicketName){
        Random RandomNumber = new Random();
        //this.Name = Name;
        String TicketCode;

        if(TicketName.isBlank()){
            System.out.println("Ticket Name is empty");
        }
        else if(TicketName.equalsIgnoreCase("All")){
            return TicketCode = "1111-" + RandomNumber.nextInt(123456789)+1;
        }
        else if(TicketName.equalsIgnoreCase("Artic")){
            return TicketCode = "2222-" + RandomNumber.nextInt(123456789)+1;
        }
        else if(TicketName.equalsIgnoreCase("River")){
            return TicketCode = "3333-" + RandomNumber.nextInt(123456789)+1;
        }
        else if(TicketName.equalsIgnoreCase("Savanna")){
            return TicketCode = "4444-" + RandomNumber.nextInt(123456789)+1;
        }
        return null;
    }

    double BankTransaction(double TicketPrice,int Amount,double money){

        // Comparing if user have enough money. if yes subtract and return
        if(money >= TicketPrice) {
            System.out.println("[+] You have RM"+money+" in your account");
            System.out.println("[+] Subtracting...");
            money = money - (TicketPrice * Amount);
            System.out.println("[+] You have RM"+money+" in your account left");
            return money;
        }
        else{
            System.out.println("[-] You Do Not have Enough Money....");
        }
        return money;
    }

    int AmountCount(int Amount){
        
    }

}


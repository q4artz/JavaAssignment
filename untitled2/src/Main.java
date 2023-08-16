import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ticket SavannaTicket = new ticket("Savanna", 20.00);
        ticket RiverTicket = new ticket("River", 20.00);
        ticket ArticTicket = new ticket("Artic", 50.00);
        ticket AllAccessTicket = new ticket("All", 80.00);

        // 0 == quit 1 == Buy 2 == Search
        int option = 1;
        int noaccountselection = 1;
        String username="";
        String purchaseOption="";
        int purchaseAmount;
        double TicketPrice;
        String TicketCode="";

        System.out.println("Please Login! (no account? press 1 to create one!)");
        noaccountselection = scanner.nextInt();
        scanner.nextLine();


        // Authenticate users --done
        if(3 == noaccountselection)
            username = RegisterUser();
        else if(noaccountselection == 2)
            username = LoginUser();
        else{
            System.out.println("[-] Invalid option..Quitting");
        }


        if(noaccountselection == 1 || noaccountselection == 2){
            while (option != 0) {
                System.out.println("\n[+] Welcome Customer, What would you like to do");
                System.out.println("\nPlease input \n \"1\" to Buy \n \"2\" to Search \n \"0\" to Quit \n");
                option = scanner.nextInt();
                scanner.nextLine();
                System.out.printf("[+] You Entered %d\n", option);

                // Buying
                if (option == 1) {
                    System.out.println("[+] Transferring to Purchasing Option");
                    purchaseOption = PurchasingOption(username);
                    purchaseAmount = PurchasingAmount(username, purchaseOption);

                    TicketPrice = GetTicketPrice(purchaseOption,purchaseAmount);

                    double money = ticket.BankTransaction(TicketPrice,purchaseAmount);

                    TicketCode = ticket.TicketGenerate(username,purchaseOption);

// for debugging before writing to file
//System.out.printf("ticket option is %s \n ticket amount is %d\n ticket price is %f\n money is %f\n ticket code is %s",purchaseOption,purchaseAmount,TicketPrice,money,TicketCode);

                    FinalWriteToFile(username,purchaseOption,purchaseAmount,money,TicketCode);

                }

                // Searching
                else if (option == 2) {
                    System.out.println("[+] Transferring to Searching Option");


                }
            }
        }
        System.out.println("[-] Exiting...");
        System.exit(0);
    }
    static String PurchasingOption(String username){
        Scanner scanner = new Scanner(System.in);
        String option;
        String optionDisplay="";
        int Amount=0;

        System.out.println("[+] Welcome "+username+ " !");
        System.out.println("[+] Which ticket would you like to buy?\n \"All Access Ticket (RM 80) Enter \t\"All\" \n \"Artic Ticket (RM50) Enter \t\"Artic\" \n \"Savanna Ticket (RM20)\" Enter \t\"Savanna\" \n \"River Ticket (RM20)\" Enter \t\"River\"\n");
        option = scanner.nextLine();

        switch (option.toUpperCase()) {
            case "ALL" -> {
                optionDisplay = "All Access Pass";
            }
            case "SAVANNA" -> {
                optionDisplay = "Savanna Ticket";
            }
            case "ARTIC" -> {
                optionDisplay = "Artic Ticket";
            }
            case "RIVER" -> {
                optionDisplay = "River Ticket";
            }
            default -> System.out.println("[-] You Did not enter a valid option..");
        }
        System.out.printf("[+] Buying %s ",optionDisplay);
        return option;
    }
    static int PurchasingAmount(String username, String option) {
        Scanner scanner = new Scanner(System.in);
        int Amount = 0;
        switch (option.toUpperCase()) {
            case "ALL" -> {
                System.out.println("[+] How Many All Access Ticket would you like to buy?");
                Amount = scanner.nextInt();
                break;
            }
            case "SAVANNA" -> {
                System.out.println("[+] How Many Savanna Ticket would you like to buy?");
                Amount = scanner.nextInt();
                break;
            }
            case "ARTIC" -> {
                System.out.println("[+] How Many Artic Ticket would you like to buy?");
                Amount = scanner.nextInt();
                break;
            }
            case "RIVER" -> {
                System.out.println("[+] How Many River Ticket would you like to buy?");
                Amount = scanner.nextInt();
                break;
            }
            default -> System.out.println("[-] You Did not enter a valid Amount..");
        }
        System.out.printf("[+] Buying %d amount of %s Tickets...",Amount,option);
        return Amount;
    }
    static double GetTicketPrice(String TicketOption, int Amount){
        double ReturnTicketPrice=0.00;
        if(TicketOption.equalsIgnoreCase("All")) {
            ReturnTicketPrice = AllAccessTicket.TicketPrice(Amount);
        }
        else if(TicketOption.equalsIgnoreCase("Artic")) {
            ReturnTicketPrice = ArticTicket.TicketPrice(Amount);
        }
        else if(TicketOption.equalsIgnoreCase("Savanna")) {
            ReturnTicketPrice = SavannaTicket.TicketPrice(Amount);
        }
        else if(TicketOption.equalsIgnoreCase("River")) {
            ReturnTicketPrice = RiverTicket.TicketPrice(Amount);
        }
        return ReturnTicketPrice;
    }

    static void SearchingOption(String username){
        Scanner scanner = new Scanner(System.in);
        String searchusername;
        if(username.equalsIgnoreCase("admin")){
            System.out.println("[+] Welcome Admin. Who's profile would you like to search?");
            searchusername = scanner.nextLine();
        }
        
    }

    static String LoginUser() throws IOException {
        Scanner scanner = new Scanner(System.in);

        String username;
        String password;

        System.out.println("[+] Please Enter Your Name");
        username = scanner.nextLine();
        System.out.println("[+] PLease Enter Your password");
        password = scanner.nextLine();

        ReadFromFile(username,password);

        return username;
    }
    static String RegisterUser() throws IOException {

        Scanner scanner = new Scanner(System.in);


        // Declear Variables
        String username;
        String password;
        String cardnumber;
        int ccv;
        int expdate;
        double money = 0.00;

        // User Input their info for Registration
        System.out.println("[+] Enter name");
        username = scanner.nextLine();
        System.out.println("[+] Enter password");
        password = scanner.nextLine();
        System.out.println("[+] Enter cardnumber");
        cardnumber = scanner.nextLine();
        System.out.println("[+] Enter ccv");
        ccv = scanner.nextInt();
        scanner.nextLine();
        System.out.println("[+] Enter expdate");
        expdate = scanner.nextInt();
        scanner.nextLine();



        user Customer = new user(username,password,cardnumber,ccv,expdate,money);

        WriteToFile(Customer);

        System.out.println("[+] Your account Has been created");

        return username;

    }
    static void WriteToFile(user Customer) throws IOException{
        // Create The file
        File file = new File("user.txt");

        // Creates a File writer class
        FileWriter fw = new FileWriter(file);

        // Creates a print writer class
        PrintWriter pw = new PrintWriter(fw);

        pw.println("line 1");
        pw.println("line 2");
        pw.println("line 3");

        pw.close();
    }
    static void ReadFromFile(String username, String password)throws IOException{

    }
    static void FinalWriteToFile(String username,String ticketOption,int Amount,double money,String TicketCode){

    }


}
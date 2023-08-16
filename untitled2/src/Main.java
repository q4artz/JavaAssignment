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
        int option = 0;
        System.out.println("\nWelcome Customer, What would you like to do");
        System.out.println("Please input \n \"1\" to Buy \n \"2\" to Search \n \"0\" to Quit \n");
        option = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("You Entered %d\n", option);

        do{
            if (option == 1) {
                System.out.println("[+] Transferring to Purchasing Option");
                Purchasing();
            } else if (option == 2) {
                System.out.println("[+] Transferring to Searching Option");
                LoginUser();
            }
        }while (option != 0);
        System.out.println("[-] Exiting...");
        System.exit(0);
    }
    static void Purchasing(){
        Scanner scanner = new Scanner(System.in);
        String option;
        System.out.println("[+] Which ticket would you like to buy? \"All Access Ticket (RM 80) Enter \"All\" \"\n \"Artic Ticket (RM50) Enter\"Artic\" \"\n \"Savanna Ticket (RM20)\" Enter \"Savanna\" \n \"River Ticket (RM20)\" Enter \"River\"\n");
        option = scanner.nextLine();

        if(option.equalsIgnoreCase("All")){

        }

    }
    static void LoginUser() throws IOException {
        Scanner scanner = new Scanner(System.in);

        String username;
        String password;

        System.out.println("[+] Please Enter Your Name");
        username = scanner.nextLine();
        System.out.println("[+] PLease Enter Your password");
        password = scanner.nextLine();

        ReadFromFile(username,password);
    }
    void RegisterUser() throws IOException {

        Scanner scanner = new Scanner(System.in);
        Random RandomNumber = new Random();

        // Declear Variables
        String username;
        String password;
        String cardnumber;
        int ccv;
        int expdate;

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

        // Randomly generate an amount of money
        double money = RandomNumber.nextDouble(1234.99)+1;

        user Customer = new user(username,password,cardnumber,ccv,expdate,money);

        WriteToFile(Customer);

        System.out.println("[+] Your account Has been created");

    }
    void WriteToFile(user Customer) throws IOException{
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


}
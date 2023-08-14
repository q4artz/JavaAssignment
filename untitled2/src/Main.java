import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        ticket SavannaTicket = new ticket("Savanna",20.00);
        ticket RiverTicket = new ticket("River",20.00);
        ticket ArticTicket = new ticket("Artic",50.00);
        ticket AllAccessTicket = new ticket("All",80.00);

        // 0 == quit 1 == Buy 2 == Search
        int option = 0;
        System.out.println("Welcome Customer, What would you like to do");
        System.out.println("");
    }

    void LoginUser(){
        Scanner scanner = new Scanner(System.in);

        String username;
        String password;
        String cardnumber;
        int ccv;
        int expdate;

        System.out.println("[+] Please Enter Your Name");
        username = scanner.nextLine();
        System.out.println("[+] PLease Enter Your password");
        password = scanner.nextLine();
    }
    void RegisterUser(){

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

        // Randomly generate an amount of money
        double money = RandomNumber.nextDouble(1234.99)+1;

        user Customer = new user(username,password,cardnumber,ccv,expdate,money);

        WriteToFile(Customer);

        System.out.println("[+] Your account Has been created");

    }
    void WriteToFile(user Customer){
        // File Function
    }
    void ReadFromFile(String username,String password){

    }


}


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {



    }
    void
    void RegisterUser(){
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        String cardnumber;
        int ccv;
        int expdate;

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

        user Customer = new user(username,password,cardnumber,ccv,expdate);
        WriteToFile(Customer);
        System.out.println("[+] Your account Has been created");

    }
    void WriteToFile(user Customer){
        // File Function
    }

}


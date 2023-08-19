import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        for(int i=0;i<=1;i++) {
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
            try {

                // 6. Create a FileOutputStream Object by passing text file
                // name which will be used to store the object state

                FileOutputStream fos = new FileOutputStream("user.txt");

                // 7. Create a ObjectOutputStream object which wraps
                // object of FileOutputStream thus helping to pass object
                // to a text file.
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                // 8. Create a User object by passing the dummy values to
                // its constructor

                user[] Customer = new user[25];

                Customer[i] = new user(username,password,cardnumber,ccv,expdate,money);

                // 9. Calling the writeObject method present in the ObjectOutputStream
                // which will save the object state into the text file created above
                oos.writeObject(Customer);


                // 10. Flushing and closing the ObjectOutputStream
                // as they are very critical resource
                oos.flush();
                oos.close();

                // 11. Assigning the user object to null so that its actual
                // object goes into unreachable state in heap ... similar to
                // destruction of object in this case
                Customer = null;

                // 12. Create a FileInputStream Object by passing text file
                // name which will be used to read the state of the object

               FileInputStream fis = new FileInputStream("user.txt");

                // 13. Create a ObjectInputStream object which wraps
                // object of FileInputStream thus helping to pass object
                // state from text file to Object

                ObjectInputStream ois = new ObjectInputStream(fis);

                // 14. In order to read the User object we will use the
                // ObjectInputStream.readObject() method. After this method gets
                // executed it reads object state from text file and return a object
                // of type Object so we need to cast it back the its origin class,
                // the User class.
// debugger                System.out.println("\n\nThis works\n\n");
                Customer[i] = (user)ois.readObject();

                // 15. After getting back the required object back, in order to prove
                // the result we outputs its state to console.
                if(Customer[i].getUsername().equalsIgnoreCase("john")) {
                    System.out.println("Name : " + Customer[i].getUsername());
                    System.out.println("pAss : " + Customer[i].getPassword());
                    System.out.println("cardnum : " + Customer[i].getCardnumber());
                    System.out.println("ccv : " + Customer[i].getCcv());
                    System.out.println("expdate : " + Customer[i].getExpdate());
                    System.out.println("money : " + Customer[i].getMoney());
                }
                // closing the critical resources
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}

class user implements Serializable{
    // Set variables
    private String username;
    private String password;
    private String cardnumber;
    private int ccv;
    private int expdate;
    private double money;

    // Constructor to set prperties to it
    public user(String username,String password,String cardnumber,int ccv,int expdate,double money){
        this.username = username;
        this.password = password;
        this.cardnumber = cardnumber;
        this.ccv = ccv;
        this.expdate = expdate;
        this.money = money;
    };

    // all the getters and Setters for each properties

    public String getUsername(){return username;}

    public void setUsername(String username){this.username = username;}

    public String getPassword(){return password;}

    public void setPassword(String password){this.password = password;}

    public String getCardnumber(){return cardnumber;}

    public void setCardnumber(String cardnumber){this.cardnumber = cardnumber;}

    public int getCcv(){return ccv;}

    public void setCcv(int ccv){this.ccv = ccv;}

    public int getExpdate(){return expdate;}

    public void setExpdate(int expdate){this.expdate = expdate;}

    public double getMoney(){return money;}

    public void setMoney(double money){this.money = money;}
}

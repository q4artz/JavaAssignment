public class user{
    String username;
    String password;
    String cardnumber;
    int ccv;
    int expdate;
    double money;

    // null constructor
    public user(){
        this.setusername("");
        this.setusername("");
    }

    // full constructor
    public user(String username){
        this.setusername(username);
    }

    // getters
    public String getUsername(){
        return this.username;
    }

    // setters
    public void setusername(String username){
        this.username = username;
    }

    //to string
    public String toString(){
        return "Name [username = "+this.getUsername() +" ]";
    }


    public user(String username,String password,String cardnumber,int ccv,int expdate,double money){
        this.username = username;
        this.password = password;
        this.cardnumber = cardnumber;
        this.ccv = ccv;
        this.expdate = expdate;
        this.money = money;
    };


}

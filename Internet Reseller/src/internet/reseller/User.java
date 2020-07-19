package internet.reseller;
import java.io.Serializable;

public class User implements Serializable {
    private String ID;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
    private boolean loggedIn;
    
    public User(){};

    public User(String ID, String name, String address, String phoneNumber, String email, String username, String password) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.loggedIn=false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

 public void login(String Username, String Password){
        if(username.equals(Username)&&password.equals(Password))
            loggedIn=true;
        else
        {   
            loggedIn=false;
        }
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setAddress(String add){
    this.address=add;
    }
    
    public void setEmail(String email){
    this.email=email;
    }
}

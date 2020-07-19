
package internet.reseller;

import internet.reseller.User;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Admin extends User implements Serializable {
    
    
  

    public Admin(String ID, String name, String address, String phoneNumber, String email, String username, String password) 
    {
        super(ID, name, address, phoneNumber, email, username, password);
    }
    
    
    public void addNewAdmin(String ID, String name, String address, String phoneNumber, String email, String username, String password) throws FileNotFoundException, IOException
    {
        
        FileOutputStream fos = new FileOutputStream("Admin.txt", true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject (new Admin(ID, name, address, phoneNumber, email, username,  password));
        
        oos.close();
        fos.close();
              
    }
    
    public void addNewSales (String ID, String name, String address, String phoneNumber, String email, String username, String password ) throws FileNotFoundException, IOException
    {
        FileOutputStream fos = new FileOutputStream("Sales.txt", true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject (new Sales(ID, name, address, phoneNumber, email, username,  password));
        
        oos.close();
        fos.close();
        
    }
    
    public void addNewFinance( String ID, String name, String address, String phoneNumber, String email, String username, String password) throws FileNotFoundException, IOException
    {
         FileOutputStream fos = new FileOutputStream("Finance.txt", true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject (new Finance(ID, name, address, phoneNumber, email, username,  password));
        
        oos.close();
        fos.close();
        
    }
}

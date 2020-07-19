package internet.reseller;

import java.io.Serializable;

public class Sales extends User implements Serializable {

    public Sales() {
    }

    public Sales(String ID, String name, String address, String phoneNumber, String email, String username, String password) {
        super(ID, name, address, phoneNumber, email, username, password);
    }
 
    public void ViewOrder(Order o){
        o.viewOrder();
    }
    
    public boolean checkAvailbilty(Product p, OrderDetail d){
        if(p.checkAvailability(d)==true)
             return true;
        else
            return false;
            }
    
    public void validateOrder(Order o){
    if(o.isSaleValidated()==true)
        System.out.println("order is validated");
    else 
    System.out.println("order is not validated");
    }
    
    
}

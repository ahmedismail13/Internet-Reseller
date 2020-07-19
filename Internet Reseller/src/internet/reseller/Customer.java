
package internet.reseller;

import java.util.ArrayList;
import java.io.Serializable;
public class Customer extends User implements Serializable  {
    
    private String dateOfBirth;
    private String nationality;
    private String creditCardNumber;
    protected ArrayList<Order> orderList;
 
    public Customer(String DOB, String nationality, String ccn, String ID, String name, String address, String phoneNumber, String email, String username, String password)
    {
        super(ID, name, address, phoneNumber, email, username, password);     
        dateOfBirth = DOB;
        this.nationality= nationality;
        creditCardNumber = ccn;
         orderList= new ArrayList<Order>();
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
    
    
    
    public void createNewOrder(String orderID, String dateOrdered, OrderDetail details)
    {
        orderList.add(new Order(orderID,dateOrdered,details));
    }
    
   public void  deleteOrder(String orderID)
    {
        for (int i=0;i<orderList.size();i++)
        {
         if(orderList.get(i).getOrderID().equals(orderID))   
         {
             orderList.remove(i);
         }
        }
    }
    
   public void  confirmOrder(String orderID)
    {
        for (int i=0;i<orderList.size();i++)
        {
         if(orderList.get(i).getOrderID().equals(orderID))   
         {
             orderList.get(i).setConfirmed(true);
         }
        }
    } 
   
   
    public void updateCreditCard (String ccn)
    {
        creditCardNumber = ccn;
    }
    
    
    public void viewProfile()
    {
        this.toString();
    }
    
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
    
    @Override
    public String toString() {
        return "Customer{" + "\ndateOfBirth=" + dateOfBirth + "\nnationality=" + nationality + "\ncreditCardNumber=" + creditCardNumber + "\n}";
    }

    
}

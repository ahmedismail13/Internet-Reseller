package internet.reseller;

import java.io.Serializable;
import java.util.ArrayList;

public class Supplier extends User implements Serializable{
    
    private ArrayList<Product> products;
    private ArrayList<Invoice>invoices;
    
    public Supplier(String ID, String name, String address, String phoneNumber, String email, String username, String password) {
        super(ID, name, address, phoneNumber, email, username, password);
        products= new ArrayList<Product>();
        invoices=new ArrayList<Invoice>();
    }
    
    public void addNewInvoice(Invoice i){
      invoices.add(i);
    }
    
    public void addNewProduct(Product p){
        products.add(p); 
    }
    
    public void viewInvoice(){
     for (int i=0; i<invoices.size(); i++)
          System.out.println((Invoice)invoices.get(i));
    }
    
    public boolean updateProduct(Product p){
         for (int i=0; i<products.size(); i++)
        {
            Product temp = (Product)products.get(i);            
            if (temp.getProductID().equals(p.getProductID()))         
            {  temp=(Product)products.remove(i); 
               products.add(p);
                 return true;}
        }
        return false;
    }
    
    public boolean deleteProduct(String id){
        for (int i=0; i<products.size(); i++)
        {
            Product p = (Product)products.get(i);            
            if (p.getProductID().equals(id))         
            {  p=(Product)products.remove(i); 
                 return true;}
        }
        return false;
        }

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }  
}

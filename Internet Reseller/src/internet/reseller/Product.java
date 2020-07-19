package internet.reseller;

import java.io.Serializable;

public class Product implements Serializable{
private String productID;
private String name;
private String category;
private String description;
private String deliveryTerms;
private int quantity;
private double price;
private String supplierID;

public Product(String productID, String name, String category, String description, String deliveryTerms,int quantity,double price,String supplierID)
{
    this.productID=productID;
    this.name=name;
    this.category=category;
    this.deliveryTerms=deliveryTerms;
    this.description=description;
    this.quantity=quantity;
    this.price=price;
    this.supplierID=supplierID;
}

public void updateProdut(String productID, String name, String category, String description, String deliveryTerms,int quantity,double price,String SupplierID){
    this.productID=productID;
    this.name=name;
    this.category=category;
    this.deliveryTerms=deliveryTerms;
    this.description=description;
    this.quantity=quantity;
    this.price=price;
    this.supplierID=SupplierID;
}

public void updateQuantity(int quantity){
        this.quantity=quantity;
}

public void viewProuct(){
System.out.println("Product "+productID+"\n Name :"+name+"\n category:"+category+"\n Description: "+description+
        "\n quantity: "+quantity+"\n Price: "+price+"\n DeliveryTerms: "+ 
        deliveryTerms+"\n Supplier ID: "+this.supplierID);}

    public boolean checkAvailability(OrderDetail e){
        if (this.quantity>e.getQuantity())    
            return true;
        else
            return false;
    }
    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }


    public String getDeliveryTerms() {
        return deliveryTerms;
    }

    public void setDeliveryTerms(String deliveryTerms) {
        this.deliveryTerms = deliveryTerms;
    }
}
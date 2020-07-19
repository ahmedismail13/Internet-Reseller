/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internet.reseller;

import java.io.Serializable;

/**
 *
 * @author Reham abbady
 */
public class OrderDetail implements Serializable {
    
    private String detailID;
    private String productID;
    private int quantity;
    private double subTotal;
    private boolean delivered;
    private Product product;
    
    public OrderDetail(String detailID, String productID, int quantity, Product p) {
        this.detailID = detailID;
        this.productID = productID;
        this.quantity=quantity;
        this.product = p;
        calculateSubTotal();
    }

    public Product getProduct() {
        return product;
    }

    
    
    public String getDetailID() {
        return detailID;
    }

    public void setDetailID(String detailID) {
        this.detailID = detailID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void calculateSubTotal() { 
      this.subTotal=product.getPrice()*quantity;
    }
    
    public void deliver()
    {
        this.delivered = true;
    }

    public void ViewOrderDerail(){
    System.out.println("product ID : "+productID+"\n"+"Quantity : "+quantity+"\n"+"subtotal :"+subTotal+"\n"+"delivred :"+delivered);
    }
    
    
}


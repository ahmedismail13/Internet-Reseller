/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internet.reseller;

import java.io.Serializable;

/**
 *
 * @author Nour
 */
public class Invoice implements Serializable{
    private String invoiceId;
    private String orderId; //object of order
    private String productId;
    private String dateCreated;
    private double total;
    private boolean paid;

    public Invoice(String invoiceId,String orderId,String productId,String dateCreated,double total){
    this.invoiceId=invoiceId;
    this.orderId=orderId;
    this.productId=productId;
    this.dateCreated=dateCreated;
    this.total=total;
    this.paid=false;
    }
    
    
    public void viewInvoice(){
    System.out.println("Invoice:"+ this.invoiceId+"\n order id: "+this.orderId+"\n Product ID: "+this.productId+"\n date Created: "+
            this.dateCreated+"\n Total:"+this.total+"\n PAying Status "+this.paid);}
    
    public void payInvoice(){
    this.paid=true;
    }
    
    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

     public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductId() {
        return productId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void setPaid() {
        this.paid = false;
    }
    public boolean isPaid() {
        return paid;
    }

}

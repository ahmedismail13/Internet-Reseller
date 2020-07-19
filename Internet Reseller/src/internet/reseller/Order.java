package internet.reseller;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable{
    private String orderID;
    private String dateOrdered;
    private boolean confirmed;
    private boolean saleValidated;
    private boolean paid;
    private boolean deliveryRequest;
    private double total;
    private ArrayList<OrderDetail> details;

    public Order(String orderID, String dateOrdered, OrderDetail details) {
        
        this.details=new ArrayList<OrderDetail>();
        this.orderID = orderID;
        this.dateOrdered = dateOrdered;
        this.details.add(details);
        this.total = calculateTotal();
        this.confirmed = false;
        this.deliveryRequest = false;
        this.paid = false;
        this.saleValidated = false;
    }
    public void addOrderDetail(OrderDetail o){
        this.details.add(o);
    }
    
    
    public double calculateTotal()
    {
        double z =0;
        for(OrderDetail x:details)
        {
            z=z+x.getSubTotal();
        }
        return z;
    }
    
    public void confirmOrder(){
        confirmed = true;
    }
    public void validateOrder(){
        saleValidated = true;
    }
    public boolean checkPayment(){
        if(paid == true)
            return true;
        else
            return false;
    }
    public void requestDelivery(){
        this.deliveryRequest = true;
    }
    public void viewOrder() {
        System.out.println("Order{" + "\norderID=" + orderID + "\ndateOrdered=" + dateOrdered + "\nconfirmed=" + confirmed + "\nsaleValidated=" + saleValidated + "\npaid=" + paid + "\ndeliveryRequest=" + deliveryRequest + "\ntotal=" + total + "\ndetails=" + details + "\n}"); 
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(String dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isSaleValidated() {
        return saleValidated;
    }

    public void setSaleValidated(boolean saleValidated) {
        this.saleValidated = saleValidated;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isDeliveryRequest() {
        return deliveryRequest;
    }

    public void setDeliveryRequest(boolean deliveryRequest) {
        this.deliveryRequest = deliveryRequest;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<OrderDetail> details) {
        this.details = details;
    }
    
}


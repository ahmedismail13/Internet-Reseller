/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internet.reseller;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ahmed
 */
public class Finance extends User implements Serializable {

    public Finance(String ID, String name, String address, String phoneNumber, String email, String username, String password) 
    {
        super(ID, name, address, phoneNumber, email, username, password);
    }
    public void viewInvoice(Supplier s){
        ArrayList<Invoice> z = s.getInvoices();
        s.viewInvoice();
    }
    public ArrayList<Invoice> payInvoice(Supplier s, String invoiceID){
        ArrayList<Invoice> z = s.getInvoices();
        for(Invoice x:z)
        {
            if(x.getInvoiceId().equals(invoiceID))
            {
                if(x.isPaid()==true)
                x.payInvoice();
            } 
        }
        return z;
    }
    
}

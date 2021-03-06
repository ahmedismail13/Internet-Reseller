package internet.reseller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewOrders extends javax.swing.JFrame {

    Customer c;
    public ViewOrders(Customer s) {
        c=s;
        initComponents();
        
        int row=0;
        int col;
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.setRowCount(c.orderList.size());
        for (int i =0;i<c.orderList.size();i++)
        {
            col =0;
            model.setValueAt(c.orderList.get(i).getOrderID(),row ,col++);
            model.setValueAt(c.orderList.get(i).getDateOrdered(),row ,col++);
            model.setValueAt((c.orderList.get(i).isConfirmed())?"Confirmed":"Not Confirmed" ,row ,col);
            row++;
        }
    }
    public ViewOrders() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        tf1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Order ID", "Date", "Satus"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Confirm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        tf1.setText("Order ID");
        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(refresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(refresh)
                    .addComponent(tf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        CustomerView cv= new CustomerView(c);
        cv.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        ArrayList <Customer> custList = new ArrayList <Customer> ();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("Customer.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            try{
                while (true)
                {
                    Customer custobj = (Customer) ois.readObject();
                    custList.add(custobj);
                }
            }
            catch(Exception e){}
            fis.close();
            ois.close();
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ViewOrders.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewOrders.class.getName()).log(Level.SEVERE, null, ex);
        }

        FileOutputStream fos;
        try {
            fos = new FileOutputStream("Customer.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            boolean valid = false;
            for (int i=0;i<custList.size();i++)
            {
                if (c.getID().equals(custList.get(i).getID()) )
                {
                    for (Order o:c.getOrderList())
                    { if(o.getOrderID().equals(tf1.getText()))
                    {for(OrderDetail d:o.getDetails()){
                    if (d.getProduct().getQuantity() < 0 ){
                        valid = false;
                         break;
                    }
                    else {valid = true;
                    }
                         }
                          }
                    }
                    
                    if (valid == true) {
                    c.confirmOrder(tf1.getText());
                    custList.get(i).confirmOrder(tf1.getText());
                    JOptionPane.showMessageDialog(this, "Success!");
            
                oos.writeObject(custList.get(i));
                    }
                    else JOptionPane.showMessageDialog(this, "Out of Stock");
                }
            }
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewOrders.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewOrders.class.getName()).log(Level.SEVERE, null, ex);
        }

        int row=0;
        int col;
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.setRowCount(c.orderList.size());
        for (int i =0;i<c.orderList.size();i++)
        {
            col =0;
            model.setValueAt(c.orderList.get(i).getOrderID(),row ,col++);
            model.setValueAt(c.orderList.get(i).getDateOrdered(),row ,col++);
            model.setValueAt((c.orderList.get(i).isConfirmed())?"Confirmed":"Not Confirmed" ,row ,col);
            row++;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed

        int row=0;
        int col;
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.setRowCount(c.orderList.size());
        for (int i =0;i<c.orderList.size();i++)
        {
            col =0;
            model.setValueAt(c.orderList.get(i).getOrderID(),row ,col++);
            model.setValueAt(c.orderList.get(i).getDateOrdered(),row ,col++);
            model.setValueAt((c.orderList.get(i).isConfirmed())?"Confirmed":"Not Confirmed" ,row ,col);
            row++;
        }

    }//GEN-LAST:event_refreshActionPerformed

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewOrders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}

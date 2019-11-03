
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bhavesh
 */
public class Add extends java.awt.Frame {

    /**
     * Creates new form Add
     */
    public Add() {
        //bname.isOpaque();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bname = new java.awt.Label();
        stock = new java.awt.Label();
        insert = new java.awt.Button();
        name = new java.awt.TextField();
        quantity = new java.awt.TextField();
        jLabel1 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bname.setBackground(java.awt.Color.white);
        bname.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bname.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 18)); // NOI18N
        bname.setText("Book Name");
        add(bname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 54, -1, -1));
        bname.isOpaque();

        stock.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 18)); // NOI18N
        stock.setText("Quantity");
        add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 115, -1, -1));

        insert.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 18)); // NOI18N
        insert.setLabel("Insert");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        add(insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 209, -1, -1));
        add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 54, 136, -1));
        add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 115, 42, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/book1.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 420, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
            String query =  "INSERT INTO `books`(`name`, `stock`) VALUES (?,?)";                       
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,name.getText());
            ps.setInt(2,Integer.parseInt(quantity.getText()));
            int r = ps.executeUpdate();
            if(r>0){
                JOptionPane.showMessageDialog(null,"Book Added");
            }
           con.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_insertActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label bname;
    private java.awt.Button insert;
    private javax.swing.JLabel jLabel1;
    private java.awt.TextField name;
    private java.awt.TextField quantity;
    private java.awt.Label stock;
    // End of variables declaration//GEN-END:variables
}

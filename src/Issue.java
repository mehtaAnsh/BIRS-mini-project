/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bhavesh
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class Issue extends javax.swing.JFrame {
    String username,name;
    /**
     * Creates new form Library
     */
    public Issue() {
        initComponents();
    }
    public Issue(String u, String n) {
        username = u;
        name = n;
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

        label1 = new java.awt.Label();
        Issue = new java.awt.Button();
        choice1 = new java.awt.Choice();
        list1 = new java.awt.List();
        label2 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        label1.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 18)); // NOI18N
        label1.setText("Available");

        Issue.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 18)); // NOI18N
        Issue.setLabel("Issue");
        Issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IssueActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 18)); // NOI18N
        label2.setText("Unavailable");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/book1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(Issue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(Issue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
            String query = "SELECT `name` FROM `books` WHERE `stock`>0";
            Statement stmt = con.createStatement();
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
             while(rs.next())
            {
                     String bname=rs.getString("name");
                     choice1.add(bname);
                     
           }
             
            String query1 = "SELECT `name` FROM `books` WHERE `stock`=0";
            Statement stmt1 = con.createStatement();
            PreparedStatement ps1 = con.prepareStatement(query1);
            
            ResultSet rs1 = ps1.executeQuery();
            
             while(rs1.next())
            {
                     String bname1=rs1.getString("name");
                     list1.add(bname1);
                     
           }             
           con.close();  
             
            
        }
        catch(Exception e){
            
        }
        
        
        
        
            
    }//GEN-LAST:event_formWindowActivated

    private void IssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IssueActionPerformed
        // TODO add your handling code here:
        String name=choice1.getSelectedItem();
        //abc.setText(name);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");                                   
                       int quantity=0;
                        String selected=choice1.getSelectedItem();
                        int index;
                       String query="SELECT `sr` FROM `books` WHERE `name`=?";                        
                            PreparedStatement ps = con.prepareStatement(query);            
                           ps.setString(1,choice1.getSelectedItem());
                            ResultSet rs=ps.executeQuery();                     
                            if(rs.next())
                            {quantity=rs.getInt("sr");}
                            
            
            
                     String query1="UPDATE `books` SET `stock` =`stock`-'1' WHERE `sr` = ? And `stock`>'0'";
                     PreparedStatement ps1=con.prepareStatement(query1);
                     ps1.setInt(1,quantity);
                     int up=ps1.executeUpdate();
                     if(up>0){
                         JOptionPane.showMessageDialog(null,"Success!");
                     }
                     String query2 = "INSERT INTO record(`Username`,`Returned`,`Name`) VALUES (?,?,?)";
                     PreparedStatement ps2 = con.prepareStatement(query2);
                     ps2.setString(1,username);
                     ps2.setBoolean(2,false);
                     ps2.setString(3, name);
                     int up2 = ps2.executeUpdate();
             
                     
                     choice1.removeAll();
                     list1.removeAll();
             
                     con.close();   
                     Home h = new Home(username,name);
                     setVisible(false);
                     h.setVisible(true);
         
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
        
    }//GEN-LAST:event_IssueActionPerformed

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
            java.util.logging.Logger.getLogger(Issue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Issue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Issue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Issue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Issue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Issue;
    private java.awt.Choice choice1;
    private javax.swing.JLabel jLabel1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables
}
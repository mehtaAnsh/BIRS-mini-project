
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class Forget_Passwd extends java.awt.Frame {

    /**
     * Creates new form Forget_Passwd
     */
    public Forget_Passwd() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new java.awt.Button();
        uname = new java.awt.Label();
        spin = new java.awt.Label();
        u_name = new java.awt.TextField();
        pin = new java.awt.TextField();
        check = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();

        button1.setLabel("button1");

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(null);

        uname.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 18)); // NOI18N
        uname.setText("Username");
        add(uname);
        uname.setBounds(58, 51, 87, 29);

        spin.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 18)); // NOI18N
        spin.setText("Security Pin");
        add(spin);
        spin.setBounds(58, 133, 98, 29);
        add(u_name);
        u_name.setBounds(230, 51, 128, 29);

        pin.setEchoChar('*');
        add(pin);
        pin.setBounds(230, 133, 54, 29);

        check.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 18)); // NOI18N
        check.setLabel("Validate");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        add(check);
        check.setBounds(157, 227, 83, 33);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/book1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 420, 320);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
        String uname=u_name.getText();
        String test=pin.getText();
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
            String query="SELECT * FROM `username` WHERE `Username`=? AND `Security`=?";                        
                            PreparedStatement ps = con.prepareStatement(query);   
                            ps.setString(1,uname);
                            ps.setString(2,test);
                            ResultSet rs=ps.executeQuery();                     
                            if(rs.next())
                            {New_Pwd n=new New_Pwd(uname);                            
                            setVisible(false);                                  
                            n.setVisible(true);}
                            else{
                                JOptionPane.showMessageDialog(null,"Invalid Entry");
                            }
                            
            
            
            con.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_checkActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Forget_Passwd().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button check;
    private javax.swing.JLabel jLabel1;
    private java.awt.TextField pin;
    private java.awt.Label spin;
    private java.awt.TextField u_name;
    private java.awt.Label uname;
    // End of variables declaration//GEN-END:variables
}


package automated.sas;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Connection;

import java.awt.event.KeyEvent;

/**
 *
 * @author Smoker
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    String sql;
    public Admin() {
        initComponents();
         conn=DBConnect.connect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField2 = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/admin.gif"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 142, 45));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("UserName:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 122, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 122, 20));

        jTextField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 190, -1));

        jPasswordField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPasswordField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField2KeyPressed(evt);
            }
        });
        getContentPane().add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 190, -1));

        login.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        login.setForeground(new java.awt.Color(255, 0, 51));
        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        logout.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 153, 0));
        logout.setText("LOGOUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed

       login();
    }//GEN-LAST:event_loginActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed

        // TODO add your handling code here:
        try {
            int response = JOptionPane.showConfirmDialog(null, "You have clicked Logout. \n Do you want to close the window?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {

                 
                HomePage lf = new HomePage();
                lf.show();
                this.dispose();
            } else if (response == JOptionPane.NO_OPTION) {
            } else if (response == JOptionPane.CLOSED_OPTION) {
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.toString());
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void jPasswordField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField2KeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        login();
    }
    }//GEN-LAST:event_jPasswordField2KeyPressed

    private void login() {
    try {
        String sql = "SELECT * FROM tbl_admin WHERE admin_name = ? AND admin_pass = ?";
        pst = conn.prepareStatement(sql); 
        pst.setString(1, jTextField2.getText());
        pst.setString(2, jPasswordField2.getText());

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(this, "Welcome");
        
            // Open the Admin_Dashboard with admin username
            Admin_Dashboard dashboard = new Admin_Dashboard();
            dashboard.setVisible(true);
        
            // Close the admin JFrame
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password",  "Invalid", JOptionPane.WARNING_MESSAGE);
        }
    } catch (Exception ex) {
        System.out.println(ex.toString());
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton login;
    private javax.swing.JButton logout;
    // End of variables declaration//GEN-END:variables
}

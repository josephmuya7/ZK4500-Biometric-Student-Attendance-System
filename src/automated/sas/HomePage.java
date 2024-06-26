
package automated.sas;

import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author 
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    
    public HomePage() {
        initComponents();
        Thread t = new Thread(){
        
            /**
             * @override
             */
            public void run() {
             try { for (;;) {
                        Calendar calendar = new GregorianCalendar();
                        SimpleDateFormat sdf = new SimpleDateFormat("MMM / dd / yyyy / ");

                        int seconds = calendar.get(Calendar.SECOND);
                        int minutes = calendar.get(Calendar.MINUTE);
                        int hour = calendar.get(Calendar.HOUR);
                        int am_pm = calendar.get(Calendar.AM_PM);
                        String ampm = "ampm";
                        if (am_pm == 0) {
                            ampm = "AM";
                        } else {
                            ampm = "PM";
                        }
                        jTime.setText(sdf.format(calendar.getTime()) + hour + ":" + minutes + ":" + seconds + " " + ampm);
                        sleep(1000);
                    }}catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
          }  
        };
        
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTime = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        home_tab = new javax.swing.JButton();
        admin_tab = new javax.swing.JButton();
        lec_tab = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        theme = new javax.swing.JButton();
        help = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTime = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HomePage", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 153, 102))); // NOI18N

        jLabelTime.setForeground(new java.awt.Color(0, 255, 51));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.cyan, java.awt.Color.white));

        home_tab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home (2)_1.png"))); // NOI18N
        home_tab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_tabActionPerformed(evt);
            }
        });

        admin_tab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/admin 2.png"))); // NOI18N
        admin_tab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_tabActionPerformed(evt);
            }
        });

        lec_tab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lecturer_1.png"))); // NOI18N
        lec_tab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_tabActionPerformed(evt);
            }
        });

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout.png"))); // NOI18N
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        theme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/theme_1.png"))); // NOI18N
        theme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themeActionPerformed(evt);
            }
        });

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/question_1.png"))); // NOI18N
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(lec_tab, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(admin_tab, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(home_tab, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(theme, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(help, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(home_tab, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(admin_tab)
                .addGap(18, 18, 18)
                .addComponent(lec_tab, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(theme, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(help)
                .addGap(18, 18, 18)
                .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTime.setBackground(new java.awt.Color(255, 0, 102));
        jTime.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 153));
        jLabel2.setText("BIOMETRIC STUDENT ATTENDANCE SYSTEM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(242, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jTime, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTime, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void admin_tabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_tabActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Admin().setVisible(true);
    }//GEN-LAST:event_admin_tabActionPerformed

    private void home_tabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_tabActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new HomePage().setVisible(true);
    }//GEN-LAST:event_home_tabActionPerformed

    private void lec_tabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_tabActionPerformed
       // TODO add your handling code here:
        setVisible(false);
        new Lecturer_Login().setVisible(true);
    }//GEN-LAST:event_lec_tabActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
         try {
        int response = JOptionPane.showConfirmDialog(null, "You have clicked Logout. \n Do you want to close the window?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            // Completely exit the application
            System.exit(0);
        } else if (response == JOptionPane.NO_OPTION) {
            // Do nothing
        } else if (response == JOptionPane.CLOSED_OPTION) {
            // Do nothing
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(rootPane, ex.toString());
    }
    }//GEN-LAST:event_logoutActionPerformed

    // Method to set the look and feel based on the selected theme
private void setLookAndFeel(String theme) {
    try {
        switch (theme) {
            case "Acryl":
                UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                break;
            case "Aero":
                UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
                break;
            case "Aluminium":
                UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                break;
            case "Bernstein":
                UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
                break;
            case "Fast":
                UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
                break;
            case "Graphite":
                UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
                break;
            case "HiFi":
                UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                break;
            case "Luna":
                UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
                break;
            case "McWin":
                UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
                break;
            case "Noire":
            {
                try {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case "Smart":
                UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                break;
            case "Texture":
                UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
                break;
            // Add more cases for additional themes if needed
        }
        // Update the UI
        SwingUtilities.updateComponentTreeUI(this);
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        ex.printStackTrace();
    }
}

    
    private void themeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themeActionPerformed
        // TODO add your handling code here:
        // Display a dialog to choose the theme
    String[] options = {"Acryl", "Aero", "Aluminium", "Bernstein", "Fast", "Graphite", "HiFi", "Luna", "McWin", "Noire", "Smart", "Texture"};
    String selectedTheme = (String) JOptionPane.showInputDialog(
            null,
            "Choose a theme:",
            "Theme Selection",
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);

    // Set the selected theme
    if (selectedTheme != null) {
        setLookAndFeel(selectedTheme);
    }
    }//GEN-LAST:event_themeActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        // TODO add your handling code here:
        try {
            // Specify the path to the documentation file
            String filePath = "C:\\Users\\Zyro\\Desktop\\bsas doc\\Biometric Student Attendance System Documentation.pdf";

            // Open the documentation file
            File file = new File(filePath);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                JOptionPane.showMessageDialog(this, "Documentation file not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error opening documentation: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_helpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admin_tab;
    private javax.swing.JButton help;
    private javax.swing.JButton home_tab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jTime;
    private javax.swing.JButton lec_tab;
    private javax.swing.JButton logout;
    private javax.swing.JButton theme;
    // End of variables declaration//GEN-END:variables
}

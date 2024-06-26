
package automated.sas;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Smoker
 */
public class Lec_Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Lec_Dashboard
     */
 
 
        String lecturerName = ""; // Variable to store the lecturer's name retrieved from the database
        String unitName = ""; // Variable to store the unit name retrieved from the database
 
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    String sql;
    public Lec_Dashboard() {
        initComponents();
        conn=DBConnect.connect();
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
                        jLabelTime.setText(sdf.format(calendar.getTime()) + hour + ":" + minutes + ":" + seconds + " " + ampm);
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
        jLabel1 = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        homepage = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        fingerprint_attendance = new javax.swing.JMenuItem();
        qrcode_attendance = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        csvs = new javax.swing.JMenuItem();
        pdf_report = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        Attendance_check = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setForeground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Lecturer(s) Dashboard");

        jLabelTime.setForeground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home (1).png"))); // NOI18N

        homepage.setText("homepage");
        homepage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homepageActionPerformed(evt);
            }
        });
        jMenu2.add(homepage);

        jMenuBar1.add(jMenu2);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/attendance.png"))); // NOI18N

        fingerprint_attendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fingerprint-scanner_1.png"))); // NOI18N
        fingerprint_attendance.setText("Fingerprint Attendance");
        fingerprint_attendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fingerprint_attendanceActionPerformed(evt);
            }
        });
        jMenu1.add(fingerprint_attendance);

        qrcode_attendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/qr-code_1.png"))); // NOI18N
        qrcode_attendance.setText("QRCode Attendance");
        qrcode_attendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qrcode_attendanceActionPerformed(evt);
            }
        });
        jMenu1.add(qrcode_attendance);

        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/attendance report.png"))); // NOI18N

        csvs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/excel_2.png"))); // NOI18N
        csvs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csvsActionPerformed(evt);
            }
        });
        jMenu3.add(csvs);

        pdf_report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pdf_1.png"))); // NOI18N
        pdf_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdf_reportActionPerformed(evt);
            }
        });
        jMenu3.add(pdf_report);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view.png"))); // NOI18N

        Attendance_check.setText("Attendance Check");
        Attendance_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Attendance_checkActionPerformed(evt);
            }
        });
        jMenu4.add(Attendance_check);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void qrcode_attendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qrcode_attendanceActionPerformed
        // TODO add your handling code here:
        // Open QR Code Attendance frame and pass the lecturer's unit information

        new QRCodeAttendance().setVisible(true);
    }//GEN-LAST:event_qrcode_attendanceActionPerformed

    private void fingerprint_attendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fingerprint_attendanceActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Student_VerificationTab().setVisible(true);
    }//GEN-LAST:event_fingerprint_attendanceActionPerformed

    private void homepageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homepageActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        setVisible(false);
        new HomePage().setVisible(true);
    }//GEN-LAST:event_homepageActionPerformed

    private void csvsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csvsActionPerformed
        // TODO add your handling code here:
    try {
            File excelFile = new File("C:\\Users\\Zyro\\Desktop\\Attendance_Report.xlsx");
            Desktop.getDesktop().open(excelFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        
    }//GEN-LAST:event_csvsActionPerformed

    private void pdf_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdf_reportActionPerformed
        // TODO add your handling code here:
       
     // TODO add your handling code here:
    try {
            File excelFile = new File("C:\\Users\\Zyro\\Desktop\\Attendance_Analysis_Report.pdf");
            Desktop.getDesktop().open(excelFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
     // TODO add your handling code here:
    try {
            File excelFile = new File("C:\\Users\\Zyro\\Desktop\\Detailed_Attendance_Analysis_Report.pdf");
            Desktop.getDesktop().open(excelFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_pdf_reportActionPerformed

    private void Attendance_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Attendance_checkActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Attendance_Check().setVisible(true);
    }//GEN-LAST:event_Attendance_checkActionPerformed


    // Method to open file with default application
private void openFile(String filePath) {
    try {
        File file = new File(filePath);
        if (file.exists()) {
            Desktop.getDesktop().open(file);
        } else {
            System.out.println("File does not exist: " + filePath);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lec_Dashboard().setVisible(true);
            }
        });
        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Attendance_check;
    private javax.swing.JMenuItem csvs;
    private javax.swing.JMenuItem fingerprint_attendance;
    private javax.swing.JMenuItem homepage;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem pdf_report;
    private javax.swing.JMenuItem qrcode_attendance;
    // End of variables declaration//GEN-END:variables
}

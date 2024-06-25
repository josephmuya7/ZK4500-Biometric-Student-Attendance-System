
package automated.sas;

/**
 *
 * @author Smoker
 */


import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.GregorianCalendar;
public class Admin_Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Admin_Dashboard
     */
    
    
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String userName;
        String unit = null;
        

        
    public Admin_Dashboard() {
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

        Horizontal_Panel = new javax.swing.JPanel();
        jLabeldate = new javax.swing.JLabel();
        jLabeltime = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jSplitPane1 = new javax.swing.JSplitPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        home = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        lec_enrollment = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        std_enrollment = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        lecturer_list = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        std_list = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        units_course = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        course_list = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        units_list = new javax.swing.JMenuItem();
        card_gen = new javax.swing.JMenu();
        std_card_gen = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Horizontal_Panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        Horizontal_Panel.setForeground(new java.awt.Color(102, 102, 102));
        Horizontal_Panel.setLayout(null);

        jLabeldate.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabeldate.setForeground(new java.awt.Color(255, 255, 255));
        Horizontal_Panel.add(jLabeldate);
        jLabeldate.setBounds(1000, 70, 190, 30);

        jLabeltime.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabeltime.setForeground(new java.awt.Color(255, 255, 255));
        Horizontal_Panel.add(jLabeltime);
        jLabeltime.setBounds(1070, 40, 110, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dashboard.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        Horizontal_Panel.add(jLabel3);
        jLabel3.setBounds(270, 10, 290, 80);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dashboard_2.png"))); // NOI18N
        Horizontal_Panel.add(jLabel5);
        jLabel5.setBounds(40, 20, 60, 50);

        jLabelTime.setForeground(new java.awt.Color(255, 102, 0));
        jLabelTime.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Horizontal_Panel.add(jLabelTime);
        jLabelTime.setBounds(680, 40, 170, 30);
        Horizontal_Panel.add(jCalendar1);
        jCalendar1.setBounds(39, 121, 900, 200);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home.png"))); // NOI18N

        home.setText("homepage");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        jMenu1.add(home);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/instructor.png"))); // NOI18N

        lec_enrollment.setText("Lecturer Enrollment");
        lec_enrollment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_enrollmentActionPerformed(evt);
            }
        });
        jMenu2.add(lec_enrollment);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/graduating-student.png"))); // NOI18N

        std_enrollment.setText("student_enrollment");
        std_enrollment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                std_enrollmentActionPerformed(evt);
            }
        });
        jMenu3.add(std_enrollment);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lectturer.png"))); // NOI18N

        lecturer_list.setText("lecturer_list");
        lecturer_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturer_listActionPerformed(evt);
            }
        });
        jMenu4.add(lecturer_list);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/student list.png"))); // NOI18N

        std_list.setText("student_list");
        std_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                std_listActionPerformed(evt);
            }
        });
        jMenu5.add(std_list);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/book.png"))); // NOI18N

        units_course.setText("Course & Units Addition");
        units_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                units_courseActionPerformed(evt);
            }
        });
        jMenu6.add(units_course);

        jMenuBar1.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/courses.png"))); // NOI18N

        course_list.setText("Courses");
        course_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_listActionPerformed(evt);
            }
        });
        jMenu7.add(course_list);

        jMenuBar1.add(jMenu7);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/units.png"))); // NOI18N

        units_list.setText("Units");
        units_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                units_listActionPerformed(evt);
            }
        });
        jMenu8.add(units_list);

        jMenuBar1.add(jMenu8);

        card_gen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/student-card.png"))); // NOI18N

        std_card_gen.setText("student_card generator");
        std_card_gen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                std_card_genActionPerformed(evt);
            }
        });
        card_gen.add(std_card_gen);

        jMenuBar1.add(card_gen);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Horizontal_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Horizontal_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void std_enrollmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_std_enrollmentActionPerformed
        
        // TODO add your handling code here:
        setVisible(false);
        new Student_EnrollmentTab().setVisible(true);
    }//GEN-LAST:event_std_enrollmentActionPerformed

    private void lec_enrollmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_enrollmentActionPerformed
        
        // TODO add your handling code here:
        setVisible(false);
        new Lecturer_Enrollment().setVisible(true);
    }//GEN-LAST:event_lec_enrollmentActionPerformed

    private void lecturer_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturer_listActionPerformed
        
        // TODO add your handling code here:
        setVisible(false);
        new Lecturers_list().setVisible(true);
    }//GEN-LAST:event_lecturer_listActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new HomePage().setVisible(true);

    }//GEN-LAST:event_homeActionPerformed

    private void std_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_std_listActionPerformed
        
        // TODO add your handling code here:
        setVisible(false);
        new Students_list().setVisible(true);
    }//GEN-LAST:event_std_listActionPerformed

    private void units_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_units_courseActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Units_Course_Addition().setVisible(true);
    }//GEN-LAST:event_units_courseActionPerformed

    private void course_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_listActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new CourseDisplay().setVisible(true);
    }//GEN-LAST:event_course_listActionPerformed

    private void units_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_units_listActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new UnitsDisplay().setVisible(true);
    }//GEN-LAST:event_units_listActionPerformed

    private void std_card_genActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_std_card_genActionPerformed
       
        // TODO add your handling code here:
        setVisible(false);
        new StudentCard().setVisible(true);
    }//GEN-LAST:event_std_card_genActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        // Provide the username when creating an instance of Admin_Dashboard
        new Admin_Dashboard().setVisible(true); // Replace "username" with the actual username
    }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Horizontal_Panel;
    private javax.swing.JMenu card_gen;
    private javax.swing.JMenuItem course_list;
    private javax.swing.JMenuItem home;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JLabel jLabeldate;
    private javax.swing.JLabel jLabeltime;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JMenuItem lec_enrollment;
    private javax.swing.JMenuItem lecturer_list;
    private javax.swing.JMenuItem std_card_gen;
    private javax.swing.JMenuItem std_enrollment;
    private javax.swing.JMenuItem std_list;
    private javax.swing.JMenuItem units_course;
    private javax.swing.JMenuItem units_list;
    // End of variables declaration//GEN-END:variables
}
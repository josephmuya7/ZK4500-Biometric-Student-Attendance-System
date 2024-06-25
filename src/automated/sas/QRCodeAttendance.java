
package automated.sas;

/**
 *
 * @author Smoker
 */

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Image;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartUtilities;
import com.opencsv.CSVWriter;
import javax.swing.SwingUtilities;
import java.util.Calendar;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.element.Table;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;


public class QRCodeAttendance extends javax.swing.JFrame implements Runnable, ThreadFactory{

    /**
     * Creates new form QRCodeAttendance
     */
    private String lecturerName;
    private String unitName;
    // Define a Calendar instance to get the current date
    private Calendar calendar = Calendar.getInstance();

    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    // Add this set as a field in your class
private Set<String> processedAttendances = new HashSet<>();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    String sql;
    int id;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // Method to get the current week number
    private int getCurrentWeekNumber() {
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }
    
    public QRCodeAttendance() {
        initComponents();
        
       
        
        conn=DBConnect.connect();
        initWebcam();
        getID();
        startClock();
        
    }
    
     private void startClock() {
        Thread clock = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Calendar calendar = Calendar.getInstance();
                        Date now = calendar.getTime();
                        String dateStr = dateFormat.format(now);
                        String timeStr = dateTimeFormat.format(now);
                        
                        jLabelTime.setText(timeStr);
                        
                        sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(QRCodeAttendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        clock.start();
    }

    

    private void resetAttendance() {
   processedAttendances.clear();
   
    // Reset attendance records in the database
    try {
        String query = "DELETE FROM tbl_qrcodeattendance";
        pst = conn.prepareStatement(query);
        pst.executeUpdate();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error resetting attendance records: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        result_field = new javax.swing.JTextField();
        back_btn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        std_name = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        std_id = new javax.swing.JTextField();
        lec_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        generatereport_btn = new javax.swing.JButton();
        jUnitComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Result");

        back_btn.setText("Dashboard");
        back_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        jLabelTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelTime.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        std_name.setEditable(false);
        std_name.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        jLabel7.setText("Student Name");

        jLabel5.setText("Student Id");

        std_id.setEditable(false);

        lec_name.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Lecturer:");

        jLabel8.setText("Unit:");

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        generatereport_btn.setText("Generate Report");
        generatereport_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        generatereport_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatereport_btnActionPerformed(evt);
            }
        });

        jUnitComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OOP", "Web Development", "Computer Graphics", "Software Engineering", "Computer Networks", "Cyber Security", "Human Computer Interaction", "Embedded Systems", "Introduction to Programming and Algorithm", "Operating Systems", "Software Engineering", "Digital Logic", "Design and Analysis of Algorithms", "Distributed Systems", "Simulation and Modeling", "Professional Issues in Information Technology" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(50, 50, 50)
                                    .addComponent(result_field, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(66, 66, 66)
                                        .addComponent(std_id, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(generatereport_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(std_name, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lec_name, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 48, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(189, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lec_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(result_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(std_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(std_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 75, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(generatereport_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(199, 199, 199))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    
    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
        
         // Stop the webcam before closing the window    
         stopWebcam();
        try {

            int response = JOptionPane.showConfirmDialog(null, "You have clicked . \n Do you want to close the window?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {

            Lec_Dashboard log = new Lec_Dashboard();
            log.setVisible(true); // Show the new Lec_Dashboard JFrame
                
                this.dispose();
            } else if (response == JOptionPane.NO_OPTION) {
            } else if (response == JOptionPane.CLOSED_OPTION) {
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.toString());
        }
    }//GEN-LAST:event_back_btnActionPerformed

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        // TODO add your handling code here:
         if ("date".equals(evt.getPropertyName())) {
        // Date selection changed, retrieve the selected date
        Date selectedDate = jDateChooser1.getDate();
        
        // Convert the selected date to LocalDate
        LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
         }
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private Map<String, String> retrieveEnrolledStudentsFromDatabase() {
    Map<String, String> enrolledStudents = new HashMap<>();
    try {
        String sql = "SELECT student_name, student_regno FROM tbl_std";
        PreparedStatement pst = conn.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String studentName = rs.getString("student_name");
            String regNumber = rs.getString("student_regno");
            enrolledStudents.put(studentName, regNumber);
        }

    } catch (SQLException e) {
        System.out.println("Error retrieving enrolled student data: " + e.getMessage());
    }
    return enrolledStudents;
}

     // Method to retrieve attended students for a specific date
private Map<String, String> retrieveAttendedStudentsForDate(LocalDate date) {
    Map<String, String> attendedStudents = new HashMap<>();
    try {
        String query = "SELECT student_name, student_regno FROM tbl_qrcodeattendance WHERE attendance_date = ?";
        pst = conn.prepareStatement(query);
        pst.setDate(1, java.sql.Date.valueOf(date));
        rs = pst.executeQuery();

        while (rs.next()) {
            String studentName = rs.getString("student_name");
            String regNumber = rs.getString("student_regno");
            attendedStudents.put(studentName, regNumber);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return attendedStudents;
}
    
    // Method to generate the attendance report
private void generateAttendanceReport(LocalDate selectedDate) {
    
    
     lecturerName = lec_name.getText().trim();
     unitName = (String) jUnitComboBox.getSelectedItem();
     
     // Get the month and date of the selected test date
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String currentMonth = selectedDate.format(monthFormatter);
        String currentDateFormatted = selectedDate.format(dateFormatter);

    
     // Retrieve enrolled students
    Map<String, String> enrolledStudents = retrieveEnrolledStudentsFromDatabase();

    // Retrieve attended students for the selected date
    Map<String, String> attendedStudents = retrieveAttendedStudentsForDate(selectedDate);

    // Get the file path for the workbook
    String filePath = "C:\\Users\\Zyro\\Desktop\\QRCodeAttendance_Report.xlsx";
    File file = new File(filePath);
    Workbook workbook;

    try {
        // Load existing workbook or create a new one
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        } else {
            workbook = new XSSFWorkbook();
        }
// Generate a valid sheet name by replacing invalid characters
String sheetName = "Attendance Report " + currentDateFormatted.replace("/", "-");
sheetName = sheetName.replaceAll("[^a-zA-Z0-9-_\\.]", "_"); // Replace invalid characters with underscores

int sheetIndex = 0;
while (workbook.getSheet(sheetName) != null) {
    sheetName = "Attendance Report " + currentDateFormatted.replace("/", "-") + " - " + (++sheetIndex);
    sheetName = sheetName.replaceAll("[^a-zA-Z0-9-_\\.]", "_"); // Replace invalid characters with underscores
}

        // Create a new sheet for the attendance report
        Sheet sheet = workbook.createSheet(sheetName);

        // Create cell styles for header, data, and present/absent indication
        CellStyle headerCellStyle = createHeaderCellStyle(workbook);
        CellStyle dataCellStyle = createDataCellStyle(workbook);
        CellStyle presentCellStyle = createPresentCellStyle(workbook);
        CellStyle absentCellStyle = createAbsentCellStyle(workbook);

        // Create header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"No", "Name", "RegNo", "Attendance Status"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Populate attendance data into the sheet
        int rowNum = 1;
        for (Map.Entry<String, String> entry : enrolledStudents.entrySet()) {
            String studentName = entry.getKey();
            String regNo = entry.getValue();
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(rowNum - 1);
            row.createCell(1).setCellValue(studentName);
            row.createCell(2).setCellValue(regNo);
            Cell statusCell = row.createCell(3);
            if (attendedStudents.containsKey(studentName)) {
                statusCell.setCellValue("Present");
                statusCell.setCellStyle(presentCellStyle);
            } else {
                statusCell.setCellValue("Absent");
                statusCell.setCellStyle(absentCellStyle);
            }
        }

        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the workbook to the file
        FileOutputStream fileOut = new FileOutputStream(filePath);
        workbook.write(fileOut);
        fileOut.close();
        System.out.println("Attendance report generated successfully: " + filePath);
    } catch (IOException e) {
        System.out.println("Error generating attendance report: " + e.getMessage());
    }
    
}

// Method to create cell style for header
private CellStyle createHeaderCellStyle(Workbook workbook) {
    CellStyle cellStyle = workbook.createCellStyle();
    Font font = workbook.createFont();
    font.setBoldweight(Font.BOLDWEIGHT_BOLD);  // Set the font weight to bold
    cellStyle.setFont(font);  // Set the font for the cell style
    return cellStyle;
}

// Method to create cell style for data cells
private CellStyle createDataCellStyle(Workbook workbook) {
    CellStyle cellStyle = workbook.createCellStyle();
    // You can customize the data cell style here, such as font size, alignment, etc.
    return cellStyle;
}

// Method to create cell style for present indication
private CellStyle createPresentCellStyle(Workbook workbook) {
    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
    cellStyle.setFillPattern((short) FillPatternType.SOLID_FOREGROUND.ordinal()); // Cast to short
    return cellStyle;
}

// Method to create cell style for absent indication
private CellStyle createAbsentCellStyle(Workbook workbook) {
    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
    cellStyle.setFillPattern((short) FillPatternType.SOLID_FOREGROUND.ordinal()); // Cast to short
    return cellStyle;
}



private LocalDate getSelectedDateFromChooser() {
    // Retrieve the selected date from the jDateChooser component
    Date selectedDate = jDateChooser1.getDate();
    
    // Convert the selected date to LocalDate
    return selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
}

    
    private void generatereport_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatereport_btnActionPerformed
        // TODO add your handling code here:// Get the selected date from the date chooser
    LocalDate selectedDate = getSelectedDateFromChooser();

    // Generate the attendance report for the selected date
    generateAttendanceReport(selectedDate);
    }//GEN-LAST:event_generatereport_btnActionPerformed
 
   
     public void getID (){
        
       try {
        // Query to retrieve the maximum ID from the tbl_fingerprintattendance table
        String sql = "SELECT MAX(id) FROM tbl_qrcodeattendance";
        pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            // Retrieve the maximum ID value
            id = rs.getInt(1);
            // Increment the ID for the next record
            id++;
            // Display the current ID in the text field
            std_id.setText(Integer.toString(id));
        }
    } catch (SQLException ex) {
        System.out.println("Error retrieving current ID: " + ex.getMessage());
    }
    }
    
   
     public void clearingFields(){
         
        result_field.setText("");
        std_id.setText("");
        std_name.setText("");
        
        getID();
    }
     
     



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QRCodeAttendance().setVisible(true);
            }
        });
    }

    private void initWebcam()
    {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);
        
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);
        
        jPanel6.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));
        executor.execute(this);
    }
    
    
    private void stopWebcam() {
    if (webcam != null && webcam.isOpen()) {
        webcam.close();
    }
}
  @Override
public void run() {
    // Clear the set at the beginning of each attendance session
    processedAttendances.clear();

    do {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(QRCodeAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }

        Result result = null;
        BufferedImage image = null;

        if (webcam.isOpen()) {
            if ((image = webcam.getImage()) == null) {
                continue;
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ex) {
                Logger.getLogger(QRCodeAttendance.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (result != null) {
                // Extract the student_regno from the QR code result
                String studentRegNo = result.getText();

                // Check if attendance has already been taken for this student in the current session
                if (processedAttendances.contains(studentRegNo)) {
                    continue; // Skip further processing for this QR code
                }

                // Fetch other details from the database using student_regno
                try {
                    String query = "SELECT * FROM tbl_std WHERE student_regno=?";
                    pst = conn.prepareStatement(query);
                    pst.setString(1, studentRegNo);
                    rs = pst.executeQuery();

                    if (rs.next()) {
                        // Set values to text fields
                        result_field.setText(studentRegNo); // You already have this from the QR code
                        std_name.setText(rs.getString("student_name"));
                        

                        // Call insertAttendance with the selected date
                        insertAttendance(jDateChooser1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                        // Add the student to the processedAttendances set
                        processedAttendances.add(studentRegNo);
                        
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }
            }
        }
    } while (true);
}


private void clearStudentInformation() {
    // Clear displayed student information in JTextFields or JLabels
    std_name.setText("");
    result_field.setText("");
    
    // Add additional fields to clear as needed
}

private void insertAttendance(LocalDate attendanceDate) {
    try {
        String reg = "INSERT INTO tbl_qrcodeattendance (student_name, student_regno, attendance_date) VALUES (?, ?, ?)";

        pst = conn.prepareStatement(reg);
        pst.setString(1, std_name.getText());
        pst.setString(2, result_field.getText());
        pst.setDate(3, java.sql.Date.valueOf(attendanceDate));
        
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(rootPane, "Attendance recorded successfully for " + attendanceDate);
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, "Error inserting attendance: " + e.getMessage());
    } finally {
        try {
            if (pst != null) {
                pst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    clearStudentInformation();
}





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JButton generatereport_btn;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JComboBox<String> jUnitComboBox;
    private javax.swing.JTextField lec_name;
    private javax.swing.JTextField result_field;
    private javax.swing.JTextField std_id;
    private javax.swing.JTextField std_name;
    // End of variables declaration//GEN-END:variables

   @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "MyThread");
        t.setDaemon(true);
        return t;
        
    }
}

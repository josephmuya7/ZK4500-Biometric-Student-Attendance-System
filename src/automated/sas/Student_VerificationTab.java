
package automated.sas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;
import com.zkteco.biometric.FingerprintSensorErrorCode;
import com.zkteco.biometric.FingerprintSensorEx;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import com.google.zxing.WriterException;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import com.hp.hpl.jena.sparql.function.library.date;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import java.util.Base64;
import java.util.Calendar;
import java.util.GregorianCalendar;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.net.URI;
import java.math.BigDecimal;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.element.Table;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.time.YearMonth;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.Map;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.Date;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.fontbox.util.autodetect.FontFileFinder;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;
import java.time.Month;
import java.text.DecimalFormat;
import java.sql.SQLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import org.apache.poi.xssf.usermodel.XSSFFont;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.DateUtil;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import java.io.FileOutputStream;
import java.time.DayOfWeek;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
/**
 *
 * @author Smoker
 */
public class Student_VerificationTab extends javax.swing.JFrame {

    /**
     * Creates new form Student_VerificationTab
     */
    
    String lecName;
    String lecUnit;
   
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    String sql;
    int id;
    
     
    
    //the width of fingerprint image
	int fpWidth = 0;
	//the height of fingerprint image
	int fpHeight = 0;
	//for verify test
	private byte[] lastRegTemp = new byte[2048];
	//the length of lastRegTemp
	private int cbRegTemp = 0;
	//pre-register template
	private byte[][] regtemparray = new byte[3][2048];
	//Register
	
	private boolean bIdentify = true;
	//finger id
	private int iFid = 1;
	
	private int nFakeFunOn = 1;
	//must be 3
	static final int enroll_cnt = 3;
	
	
	private byte[] imgbuf = null;
	private byte[] template = new byte[2048];
	private int[] templateLen = new int[1];
	private byte[] fingerprint = new byte[2048];
	
	private boolean mbStop = true;
	private long mhDevice = 0;
	private long mhDB = 0;
    
           private WorkThread workThread;
           private boolean isFingerPlaced = false; // Flag to track if a finger is placed
           private static final String FINGERPRINT_IMAGE_PATH = "C:\\test\\fingerprint_images\\";
   
            private List<byte[]> enrolledTemplates = new ArrayList<>();
           // Declare studentId as a class-level variable
    private int studentId;

     
   
    
    // ...
public Student_VerificationTab() {
        initComponents();
        
        conn=DBConnect.connect();
        getID();
        
        
        
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
        lblfinger = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        jLabelTime = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        btnopen = new javax.swing.JButton();
        std_name = new javax.swing.JTextField();
        std_regno = new javax.swing.JTextField();
        std_id = new javax.swing.JTextField();
        lec_name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jUnitComboBox = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jMonthComboBox = new javax.swing.JComboBox<>();
        analyze_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_close.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_close.setText("close");
        btn_close.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });

        back_btn.setText("Dashboard");
        back_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        jLabelTime.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane2.setViewportView(textArea);

        btnopen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnopen.setText("Open");
        btnopen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnopen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnopenActionPerformed(evt);
            }
        });

        std_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                std_nameActionPerformed(evt);
            }
        });

        lec_name.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel8.setText("Unit:");

        jLabel4.setText("Lecturer:");

        jUnitComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OOP", "Web Development", "Computer Graphics", "Software Engineering", "Computer Networks", "Cyber Security", "Human Computer Interaction", "Embedded Systems", "Introduction to Programming and Algorithm", "Operating Systems", "Software Engineering", "Digital Logic", "Design and Analysis of Algorithms", "Distributed Systems", "Simulation and Modeling", "Professional Issues in Information Technology" }));
        jUnitComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUnitComboBoxActionPerformed(evt);
            }
        });

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February ", "March", "April", "May", "June", "July ", "August ", "September", "October", "November", "December" }));
        jMonthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMonthComboBoxActionPerformed(evt);
            }
        });

        analyze_btn.setText("Analyze");
        analyze_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        analyze_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyze_btnActionPerformed(evt);
            }
        });

        jLabel5.setText("Id:");

        jLabel6.setText("Student Name:");

        jLabel7.setText("Student RegNo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(analyze_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(117, 117, 117)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lec_name))
                                    .addGap(51, 51, 51)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblfinger, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btn_close, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnopen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(std_regno, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(std_name)
                                    .addComponent(std_id))
                                .addGap(51, 51, 51)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lec_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(30, 30, 30))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)))
                                                .addComponent(std_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel5))
                                        .addGap(13, 13, 13)
                                        .addComponent(std_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(std_regno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(63, 63, 63)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addComponent(lblfinger, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnopen)
                        .addGap(18, 18, 18)
                        .addComponent(btn_close)
                        .addGap(222, 222, 222)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back_btn)
                    .addComponent(analyze_btn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
     
     
    public void getID (){
        
       try {
        // Query to retrieve the maximum ID from the tbl_fingerprintattendance table
        String sql = "SELECT MAX(id) FROM tbl_fingerprintattendance";
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


     
    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
    FreeSensor();
    isFingerPlaced = false; // Reset the flag when closing the sensor
    JOptionPane.showMessageDialog(null, "Biometric Device closed Successfully!");
    }//GEN-LAST:event_btn_closeActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:

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

    private void btnopenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnopenActionPerformed
        // TODO Auto-generated method stub
        if (0 != mhDevice)
        {
            //already inited
            textArea.setText("Please close device first!");
            return;
        }
        int ret = FingerprintSensorErrorCode.ZKFP_ERR_OK;
        //Initialize
        cbRegTemp = 0;

        // Set the bIdentify flag to true for identification
        bIdentify = false;
        iFid = 1;

        if (FingerprintSensorErrorCode.ZKFP_ERR_OK != FingerprintSensorEx.Init())
        {
            textArea.setText("Init failed!");
            return;
        }
        ret = FingerprintSensorEx.GetDeviceCount();
        if (ret < 0)
        {
            textArea.setText("No devices connected!");
            FreeSensor();
            return;
        }
        if (0 == (mhDevice = FingerprintSensorEx.OpenDevice(0)))
        {
            textArea.setText("Open device fail, ret = " + ret + "!");
            FreeSensor();
            return;
        }
        if (0 == (mhDB = FingerprintSensorEx.DBInit()))
        {
            textArea.setText("Init DB fail, ret = " + ret + "!");
            FreeSensor();
            return;
        }

        //set fakefun off

        //FingerprintSensorEx.SetParameter(mhDevice, 2002, changeByte(nFakeFunOn), 4);

        byte[] paramValue = new byte[4];
        int[] size = new int[1];
        //GetFakeOn
        //size[0] = 4;
        //FingerprintSensorEx.GetParameters(mhDevice, 2002, paramValue, size);
        //nFakeFunOn = byteArrayToInt(paramValue);

        size[0] = 4;
        FingerprintSensorEx.GetParameters(mhDevice, 1, paramValue, size);
        fpWidth = byteArrayToInt(paramValue);
        size[0] = 4;
        FingerprintSensorEx.GetParameters(mhDevice, 2, paramValue, size);
        fpHeight = byteArrayToInt(paramValue);
        //width = fingerprintSensor.getImageWidth();
        //height = fingerprintSensor.getImageHeight();
        imgbuf = new byte[fpWidth*fpHeight];
        lblfinger.resize(fpWidth, fpHeight);
        mbStop = false;
        workThread = new WorkThread();
        workThread.start();// 绾跨▼鍚姩
        JOptionPane.showMessageDialog(null, "Biometric Device Opened Successfully!");

        // Load all enrolled templates
    enrolledTemplates = loadEnrolledTemplates();
    }//GEN-LAST:event_btnopenActionPerformed



    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        if ("date".equals(evt.getPropertyName())) {
        // Date selection changed, retrieve the selected date
        Date selectedDate = jDateChooser1.getDate();
        
        // Convert the selected date to LocalDate
        LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
       
    }
    }//GEN-LAST:event_jDateChooser1PropertyChange

    
   

    
     private Month getSelectedMonth() {
    // Assuming you have a JComboBox to select the month(s) named jMonthComboBox
    // You can modify this according to your GUI components
    int selectedIndex = jMonthComboBox.getSelectedIndex();
    if (selectedIndex != -1) {
        // Assuming the JComboBox contains Month enum values as items
        return Month.values()[selectedIndex];
    } else {
        return null;
    }
}
    
    
    private int retrieveTotalEnrolledStudents() {
    int totalEnrolled = 0;
    try {
        String sql = "SELECT COUNT(student_regno) FROM tbl_std";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            totalEnrolled = rs.getInt(1);
        }
    } catch (SQLException e) {
        System.out.println("Error retrieving total enrolled student count: " + e.getMessage());
    }
    return totalEnrolled;
}

    private String getSelectedUnit() {
    // Assuming jUnitComboBox is your JComboBox containing units
    return (String) jUnitComboBox.getSelectedItem();
}

    private void analyze_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyze_btnActionPerformed
        // Get the selected month and unit
    Month selectedMonth = getSelectedMonth();  // Assuming this method is defined to fetch the selected month
    String selectedUnit = getSelectedUnit();  // Fetches the selected unit from the JComboBox

    // Retrieve total enrolled students
    int totalEnrolled = retrieveTotalEnrolledStudents();  // Retrieve the total number of enrolled students

    
     // Retrieve attendance data for the selected month and unit
    Map<LocalDate, Map<String, String>> attendanceData = retrieveAttendanceDataForMonth(selectedMonth, selectedUnit);

       // Retrieve individual student attendance details for the selected month
    Map<String, Set<LocalDate>> studentAttendance = retrieveStudentAttendanceForMonthAndUnit(selectedMonth, selectedUnit);

    // Calculate attendance percentages for the selected unit
    Map<Month, Double> attendancePercentages = calculateAttendancePercentages(attendanceData, totalEnrolled, selectedUnit);
 

    // Generate PDF reports
    generateAttendanceAnalysisReport(attendancePercentages, selectedUnit, selectedMonth);
    generateDetailedAttendanceAnalysisReport(studentAttendance, selectedMonth, selectedUnit);

    // Calling the method to generate the Excel attendance sheet
    generateExcelAttendanceSheet();


    }//GEN-LAST:event_analyze_btnActionPerformed



    private void jUnitComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUnitComboBoxActionPerformed
        // TODO add your handling code here:
        // Get the selected unit from the combo box
    String selectedUnit = (String) jUnitComboBox.getSelectedItem();
    
    }//GEN-LAST:event_jUnitComboBoxActionPerformed

    private void std_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_std_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_std_nameActionPerformed

    private void jMonthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMonthComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMonthComboBoxActionPerformed

    

private Map<LocalDate, Map<String, String>> retrieveAttendanceDataForMonth(Month month, String selectedUnit) {
    Map<LocalDate, Map<String, String>> attendanceData = new HashMap<>();
    try {
        // Ensure that the SQL query specifically filters by month and unit
        String sql = "SELECT DATE(attendance_date) AS att_date, student_name, student_regno FROM tbl_fingerprintattendance " +
                     "WHERE MONTH(attendance_date) = ? AND unit_name = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, month.getValue());  // Month filter
        pst.setString(2, selectedUnit);  // Unit filter

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            LocalDate attendanceDate = rs.getDate("att_date").toLocalDate();
            String studentName = rs.getString("student_name") + " " + rs.getString("student_regno"); // Concatenate for key
            attendanceData.putIfAbsent(attendanceDate, new HashMap<>());
            attendanceData.get(attendanceDate).put(studentName, selectedUnit);
        }
    } catch (SQLException e) {
        System.out.println("SQL Error in retrieveAttendanceDataForMonth: " + e.getMessage());
    }
    return attendanceData;
}

 private Map<String, Set<LocalDate>> retrieveStudentAttendanceForMonthAndUnit(Month month, String selectedUnit) {
    Map<String, Set<LocalDate>> studentAttendance = new HashMap<>();
    try {
        String sql = "SELECT attendance_date, student_name FROM tbl_fingerprintattendance WHERE MONTH(attendance_date) = ? AND unit_name = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, month.getValue()); // Set the month value as a parameter
        pst.setString(2, selectedUnit); // Set the selected unit as another parameter
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            LocalDate attendanceDate = rs.getDate("attendance_date").toLocalDate();
            String studentName = rs.getString("student_name");
            studentAttendance.computeIfAbsent(studentName, k -> new HashSet<>()).add(attendanceDate);
        }
    } catch (SQLException e) {
        System.out.println("Error retrieving detailed attendance data for the selected month and unit: " + e.getMessage());
    }
    return studentAttendance;
}

  
private Map<Month, Double> calculateAttendancePercentages(Map<LocalDate, Map<String, String>> attendanceData, int totalEnrolled, String selectedUnit) {
    Map<Month, List<Double>> monthlyAttendance = new HashMap<>();
    DecimalFormat df = new DecimalFormat("#.##");

    attendanceData.forEach((date, dailyAttendance) -> {
        Month month = date.getMonth();
        // Filter and count entries specifically for the selected unit
        long attendedStudentsForUnit = dailyAttendance.entrySet().stream()
            .filter(entry -> entry.getValue().equals(selectedUnit))
            .count();

        if (attendedStudentsForUnit > 0) {  // Ensure we're not dividing by zero
            double attendancePercentage = (double) attendedStudentsForUnit / totalEnrolled * 100;
            monthlyAttendance.computeIfAbsent(month, k -> new ArrayList<>()).add(attendancePercentage);
        }
    });

    // Compute average attendance percentages for each month
    Map<Month, Double> attendancePercentages = new HashMap<>();
    monthlyAttendance.forEach((month, percentages) -> {
        double averagePercent = percentages.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        // Format and store average percentage
        attendancePercentages.put(month, Double.valueOf(df.format(averagePercent)));
    });

    return attendancePercentages;
}


private void generateAttendanceAnalysisReport(Map<Month, Double> attendancePercentages, String selectedUnit, Month selectedMonth) {
    Document document = new Document();

    // Define fonts with colors
    Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD, BaseColor.RED);
    Font monthAndUnitFont = FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
    Font percentageFont = FontFactory.getFont(FontFactory.HELVETICA, 14, Font.NORMAL, BaseColor.GREEN);

    try {
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Zyro\\Desktop\\Attendance_Analysis_Report_" + selectedMonth + "_" + selectedUnit + ".pdf"));
        document.open();
        
        // Add a colorful title
        document.add(new Paragraph("Attendance Analysis Report", titleFont));
        document.add(new Paragraph("Month: " + selectedMonth, monthAndUnitFont));
        document.add(new Paragraph("Unit: " + selectedUnit, monthAndUnitFont));
        document.add(new Paragraph("\n"));  // Adding spacing for better readability

        // Add colorful attendance percentage text
        Double attendancePercentage = attendancePercentages.getOrDefault(selectedMonth, 0.0);
        String percentageText = String.format("Attendance in %s for unit %s: %.2f%%", selectedMonth, selectedUnit, attendancePercentage);
        document.add(new Paragraph(percentageText, percentageFont));

        document.close();
        JOptionPane.showMessageDialog(null, "PDF Attendance Analysis report for " + selectedMonth + " in unit " + selectedUnit + " generated successfully!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Failed to generate the colorful PDF report: " + e.getMessage());
    }
}



private Set<LocalDate> fetchAllClassDatesForMonthAndUnit(Month month, String selectedUnit) {
    Set<LocalDate> classDates = new HashSet<>();
    try {
        String sql = "SELECT DISTINCT DATE(attendance_date) AS class_date FROM tbl_fingerprintattendance WHERE MONTH(attendance_date) = ? AND unit_name = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, month.getValue());
        pst.setString(2, selectedUnit);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            LocalDate classDate = rs.getDate("class_date").toLocalDate();
            classDates.add(classDate);
        }
    } catch (SQLException e) {
        System.out.println("Error retrieving all class dates: " + e.getMessage());
    }
    return classDates;
}

private void generateDetailedAttendanceAnalysisReport(Map<String, Set<LocalDate>> studentAttendance, Month selectedMonth, String selectedUnit) {
    Document document = new Document();
    Set<LocalDate> allClassDates = fetchAllClassDatesForMonthAndUnit(selectedMonth, selectedUnit);

    // Define colors
    Font headerFont = FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
    Font subHeaderFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, BaseColor.DARK_GRAY);
    Font studentNameFont = FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, BaseColor.RED);
    Font dateFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL, BaseColor.GREEN);

    try {
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Zyro\\Desktop\\Detailed_Attendance_Analysis_Report_" + selectedMonth + "_" + selectedUnit + ".pdf"));
        document.open();

        document.add(new Paragraph("Detailed Attendance Report for " + selectedMonth + " - Unit: " + selectedUnit, headerFont));

        for (Map.Entry<String, Set<LocalDate>> entry : studentAttendance.entrySet()) {
            document.add(new Paragraph("Student: " + entry.getKey(), studentNameFont));
            document.add(new Paragraph("Attended Dates:", subHeaderFont));
            for (LocalDate date : entry.getValue()) {
                document.add(new Paragraph(" - " + date, dateFont));
            }

            Set<LocalDate> missedDates = new HashSet<>(allClassDates);
            missedDates.removeAll(entry.getValue());
            document.add(new Paragraph("Missed Dates:", subHeaderFont));
            for (LocalDate date : missedDates) {
                document.add(new Paragraph(" - " + date, dateFont));
            }

            document.add(new Paragraph("\n"));
        }
        document.close();

        JOptionPane.showMessageDialog(null, "PDF Detailed Attendance Analysis report generated successfully!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Failed to generate the colorful PDF report: " + e.getMessage());
    }
}

  
private LocalDate getStartDate() {
    // Return a fixed start date for demonstration
    return LocalDate.of(2024, Month.MAY, 1);  // Customize as needed
}
private List<Student> fetchStudentsInUnit() {
    List<Student> students = new ArrayList<>();
    String sql = "SELECT student_name, student_regno FROM tbl_std";
    try (PreparedStatement pst = conn.prepareStatement(sql)) {
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String name = rs.getString("student_name");
            String regNo = rs.getString("student_regno");
            students.add(new Student(name, regNo));  // Assuming Student is a predefined class
        }
    } catch (SQLException e) {
        System.out.println("Error retrieving students: " + e.getMessage());
    }
    return students;
}
private Map<String, List<LocalDate>> fetchAttendanceData(String unit) {
    Map<String, List<LocalDate>> attendanceData = new HashMap<>();
    String sql = "SELECT student_regno, attendance_date FROM tbl_fingerprintattendance WHERE unit_name = ?";
    try (PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, unit);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String regNo = rs.getString("student_regno");
            LocalDate attendanceDate = rs.getDate("attendance_date").toLocalDate();
            attendanceData.computeIfAbsent(regNo, k -> new ArrayList<>()).add(attendanceDate);
        }
    } catch (SQLException e) {
        System.out.println("Error fetching attendance data: " + e.getMessage());
    }
    return attendanceData;
}
private void processAttendanceForUnit(String unit) {
    // Fetch all students
    List<Student> students = fetchStudentsInUnit();  // Assumes method returns all students
    
    // Fetch attendance data for the specified unit
    Map<String, List<LocalDate>> attendanceData = fetchAttendanceData(unit);

    // Iterate through list of students and match their attendance records
    for (Student student : students) {
        List<LocalDate> datesAttended = attendanceData.getOrDefault(student.getRegNo(), new ArrayList<>());
        System.out.println("Student: " + student.getName() + " (" + student.getRegNo() + ")");
        System.out.println("Dates Attended in " + unit + ": " + datesAttended);
    }
}
private void generateExcelAttendanceSheet() {
    // Fetch selected unit
    String selectedUnit = getSelectedUnit();
    
    // Calculate date range based on the start date and the number of weeks
    LocalDate startDate = getStartDate();
    LocalDate endDate = startDate.plusWeeks(4);  // Assuming a 4-week period here as an example

    // Fetch all enrolled students
    List<Student> enrolledStudents = fetchStudentsInUnit();  // Modified to fetch all, earlier it was fetchStudentsInUnit(selectedUnit)
    
    // Fetch attendance data within the date range for the selected unit
    Map<String, List<LocalDate>> studentAttendance = fetchAttendanceData(selectedUnit);  // We've adjusted the attendance fetching method

    // Define file path and workbook
    String filePath = "C:\\Users\\Zyro\\Desktop\\Attendance_Sheet_" + selectedUnit + ".xlsx";
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("Weekly Attendance");

    // Create headers
    XSSFRow headerRow = sheet.createRow(0);
    headerRow.createCell(0).setCellValue("Student Name");
    for (int i = 1; i <= 4; i++) {  // Create headers for each week
        headerRow.createCell(i).setCellValue("Week " + i);
    }
    
    // Fill in student names and their weekly attendance
    int rowNum = 1;
    for (Student student : enrolledStudents) {
        XSSFRow row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(student.getName());
        List<LocalDate> datesAttended = studentAttendance.getOrDefault(student.getRegNo(), new ArrayList<>());
        
        // Check attendance for each week and set cell values
        for (int week = 1; week <= 4; week++) {
            LocalDate weekStart = startDate.plusWeeks(week - 1);
            LocalDate weekEnd = weekStart.plusDays(6);
            long attendanceCount = datesAttended.stream()
                .filter(d -> !d.isBefore(weekStart) && !d.isAfter(weekEnd))
                .count();
            row.createCell(week).setCellValue(attendanceCount > 0 ? "Present" : "Absent");
        }
    }
    
    // Auto-size columns for aesthetics
    for (int i = 0; i <= 4; i++) {
        sheet.autoSizeColumn(i);
    }

    // Write the output to a file
    try (FileOutputStream out = new FileOutputStream(new File(filePath))) {
        workbook.write(out);
        JOptionPane.showMessageDialog(null, "Excel attendance sheet generated successfully!");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error writing Excel file: " + e.getMessage());
    }
}

    

    public static void writeBitmap(byte[] imageBuf, int nWidth, int nHeight,
			String path) throws IOException {
		java.io.FileOutputStream fos = new java.io.FileOutputStream(path);
		java.io.DataOutputStream dos = new java.io.DataOutputStream(fos);

		int w = (((nWidth+3)/4)*4);
		int bfType = 0x424d; 
		int bfSize = 54 + 1024 + w * nHeight;
		int bfReserved1 = 0;
		int bfReserved2 = 0;
		int bfOffBits = 54 + 1024;

		dos.writeShort(bfType); 
		dos.write(changeByte(bfSize), 0, 4); 
		dos.write(changeByte(bfReserved1), 0, 2);
		dos.write(changeByte(bfReserved2), 0, 2);
		dos.write(changeByte(bfOffBits), 0, 4);

		int biSize = 40;
		int biWidth = nWidth;
		int biHeight = nHeight;
		int biPlanes = 1; 
		int biBitcount = 8;
		int biCompression = 0;
		int biSizeImage = w * nHeight;
		int biXPelsPerMeter = 0;
		int biYPelsPerMeter = 0;
		int biClrUsed = 0;
		int biClrImportant = 0;

		dos.write(changeByte(biSize), 0, 4);
		dos.write(changeByte(biWidth), 0, 4);
		dos.write(changeByte(biHeight), 0, 4);
		dos.write(changeByte(biPlanes), 0, 2);
		dos.write(changeByte(biBitcount), 0, 2);
		dos.write(changeByte(biCompression), 0, 4);
		dos.write(changeByte(biSizeImage), 0, 4);
		dos.write(changeByte(biXPelsPerMeter), 0, 4);
		dos.write(changeByte(biYPelsPerMeter), 0, 4);
		dos.write(changeByte(biClrUsed), 0, 4);
		dos.write(changeByte(biClrImportant), 0, 4);

		for (int i = 0; i < 256; i++) {
			dos.writeByte(i);
			dos.writeByte(i);
			dos.writeByte(i);
			dos.writeByte(0);
		}

		byte[] filter = null;
		if (w > nWidth)
		{
			filter = new byte[w-nWidth];
		}
		
		for(int i=0;i<nHeight;i++)
		{
			dos.write(imageBuf, (nHeight-1-i)*nWidth, nWidth);
			if (w > nWidth)
				dos.write(filter, 0, w-nWidth);
		}
		dos.flush();
		dos.close();
		fos.close();
	}

	public static byte[] changeByte(int data) {
		return intToByteArray(data);
	}
	
	public static byte[] intToByteArray (final int number) {
		byte[] abyte = new byte[4];  
	    
	    abyte[0] = (byte) (0xff & number);  
	    
	    abyte[1] = (byte) ((0xff00 & number) >> 8);  
	    abyte[2] = (byte) ((0xff0000 & number) >> 16);  
	    abyte[3] = (byte) ((0xff000000 & number) >> 24);  
	    return abyte; 
	}	 
		 
		public static int byteArrayToInt(byte[] bytes) {
			int number = bytes[0] & 0xFF;  
		    
		    number |= ((bytes[1] << 8) & 0xFF00);  
		    number |= ((bytes[2] << 16) & 0xFF0000);  
		    number |= ((bytes[3] << 24) & 0xFF000000);  
		    return number;  
		 }
                
    public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
            	FreeSensor();
            }
    
    private void FreeSensor()
	{
		mbStop = true;
		try {		//wait for thread stopping
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (0 != mhDB)
		{
			FingerprintSensorEx.DBFree(mhDB);
			mhDB = 0;
		}
		if (0 != mhDevice)
		{
			FingerprintSensorEx.CloseDevice(mhDevice);
			mhDevice = 0;
		}
		FingerprintSensorEx.Terminate();
	}
  // Modify your WorkThread to include verifying
private class WorkThread extends Thread {
    
   

    @Override
    public void run() {
        int ret = 0;
        while (!mbStop) {
            templateLen[0] = 2048;
            if (0 == (ret = FingerprintSensorEx.AcquireFingerprint(mhDevice, imgbuf, template, templateLen))) {
                
                
                OnCaptureOK(imgbuf);
                
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

     private void runOnUiThread(Runnable runnable) {
        // TODO Auto-generated method stub
    }
}


private void OnCaptureOK(byte[] imgbuf) {
    // Verify the captured image against the last enrolled template
    verifyCapturedImage(imgbuf);
}


private List<byte[]> loadEnrolledTemplates() {
    List<byte[]> enrolledTemplates = new ArrayList<>();

    try {
        String sql = "SELECT fingerprint FROM tbl_std";
        PreparedStatement pst = conn.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            // Retrieve each enrolled fingerprint template from the database
            byte[] template = rs.getBytes("fingerprint");
            System.out.println("Retrieved template length: " + (template != null ? template.length : 0));
            enrolledTemplates.add(template);
        }

    } catch (SQLException e) {
        System.out.println("Error retrieving enrolled fingerprint templates: " + e.getMessage());
    }

    return enrolledTemplates;
}

private void verifyCapturedImage(byte[] imgbuf) {
    if (0 == mhDB) {
        textArea.setText("Please open device first!");
        return;
    }

    // Save the captured image to a temporary file
    String imagePath = FINGERPRINT_IMAGE_PATH + "captured_fingerprint.bmp";
    try {
        writeBitmap(imgbuf, fpWidth, fpHeight, imagePath);
    } catch (IOException ex) {
        Logger.getLogger(Student_VerificationTab.class.getName()).log(Level.SEVERE, null, ex);
    }

    // Extract template from the saved image file
    byte[] capturedTemplate = new byte[2048];
    int[] sizeCapturedTemplate = new int[1];
    sizeCapturedTemplate[0] = 2048;
    int ret = FingerprintSensorEx.ExtractFromImage(mhDB, imagePath, 500, capturedTemplate, sizeCapturedTemplate);

    if (ret == 0) {
        boolean verificationSuccessful = false;

        // Iterate through all enrolled templates
        for (byte[] enrolledTemplate : enrolledTemplates) {
            // Verify the captured template against each enrolled template
            ret = FingerprintSensorEx.DBMatch(mhDB, enrolledTemplate, capturedTemplate);
            if (ret > 0) {
                 JOptionPane.showMessageDialog(null, "Verification successful, score=" + ret);
                // Display student information only when verification is successful
                displayStudentInformationByTemplate(enrolledTemplate);
                verificationSuccessful = true;
                break; // Break the loop on the first successful verification
            }
        }

        if (!verificationSuccessful) {
            JOptionPane.showMessageDialog(null, "Verification failure");
            
            clearStudentInformation();
        }

    } else {
        JOptionPane.showMessageDialog(null, "ExtractFromImage fail, ret=" + ret);
       
    }
}



 private byte[] retrieveEnrolledTemplateFromDatabase() {
    try {
        String sql = "SELECT fingerprint FROM tbl_std ORDER BY student_id DESC LIMIT 1";
        PreparedStatement pst = conn.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            // Retrieve the last enrolled fingerprint template from the database
            byte[] template = rs.getBytes("fingerprint");
            System.out.println("Retrieved template length: " + (template != null ? template.length : 0));
            return template;
        } else {
            System.out.println("No enrolled fingerprint templates found in the database.");
            return null;
        }
    } catch (SQLException e) {
        System.out.println("Error retrieving enrolled fingerprint template: " + e.getMessage());
        return null;
    }
}
 
 

   private void displayStudentInformationByTemplate(byte[] template) {
    try {
        String sql = "SELECT student_name, student_regno FROM tbl_std WHERE fingerprint = ?";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setBytes(1, template);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            std_name.setText(rs.getString("student_name"));
            std_regno.setText(rs.getString("student_regno"));
            
            // Retrieve unit name from combo box before calling insertAttendance
            String unitName = jUnitComboBox.getSelectedItem().toString();
            LocalDate attendanceDate = jDateChooser1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            // Call insertAttendance with the selected date and unit name
            insertAttendance(attendanceDate, unitName);
            
            System.out.println("Student information found for the provided template.");

        } else {
            System.out.println("No student information found for the provided template.");
            clearStudentInformation();
        }
    } catch (SQLException e) {
        System.out.println("Error retrieving student information: " + e.getMessage());
        // Handle the error, e.g., display an error message
    }
}



private void clearStudentInformation() {
    // Clear displayed student information in JTextFields or JLabels
    std_name.setText("");
    std_regno.setText("");
    
    // Add additional fields to clear as needed
}

private void insertAttendance(LocalDate attendanceDate, String unitName) {
    try {
        
        unitName = (String) jUnitComboBox.getSelectedItem();
        String sql = "INSERT INTO tbl_fingerprintattendance (student_name, student_regno, attendance_date, unit_name) VALUES (?, ?, ?, ?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, std_name.getText());
        pst.setString(2, std_regno.getText());
        pst.setDate(3, java.sql.Date.valueOf(attendanceDate));
        pst.setString(4, unitName);
        
        pst.executeUpdate();
        
        
        JOptionPane.showMessageDialog(rootPane, "Attendance recorded successfully for " + attendanceDate + " in unit " + unitName);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, "Error inserting attendance: " + e.getMessage());
    }
    
    clearStudentInformation();
}


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_VerificationTab().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analyze_btn;
    private javax.swing.JButton back_btn;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btnopen;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JComboBox<String> jMonthComboBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jUnitComboBox;
    private javax.swing.JButton lblfinger;
    private javax.swing.JTextField lec_name;
    private javax.swing.JTextField std_id;
    private javax.swing.JTextField std_name;
    private javax.swing.JTextField std_regno;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}

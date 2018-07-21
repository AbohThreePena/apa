package aplikasi;

import com.sun.glass.events.KeyEvent;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import koneksi.koneksiDB;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

public class lossTicket extends javax.swing.JFrame {
    
    private String noIden ="";
    private Integer harga = 0;
    
    public lossTicket() {
        initComponents();
        panggilDBKendaraan();
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton2.setEnabled(false);
        nomorForm();
        jLabel11.setText("Rp. 0");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(241, 242, 246));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(1007, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_ic_close_48px_352270.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(979, 3, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_BT_print_905645 (1).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(774, 484, 208, 228));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "STNK", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 18), new java.awt.Color(214, 48, 49))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(214, 48, 49));
        jPanel2.setPreferredSize(new java.awt.Dimension(240, 240));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 472, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "KTP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 18), new java.awt.Color(214, 48, 49))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(240, 240));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 472, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SIM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 18), new java.awt.Color(214, 48, 49))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(240, 240));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 472, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_icons_photo_1564522.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 718, 100, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_icons_photo_1564522.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 720, 100, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_icons_photo_1564522.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 718, 100, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Kendaraan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 24), new java.awt.Color(214, 48, 49))); // NOI18N

        jTextField1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel1.setText(" NOMOR POLISI");

        jComboBox1.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel2.setText("JENIS KENDARAAN");

        jTextField2.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel6.setText("NOMOR IDENTITAS KTP/SIM");

        jTextField3.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel8.setText("WAKTU MASUK");

        jButton6.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton6.setText("SUBMIT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton7.setText("CLEAR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 14, 305, 380));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto Keluar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 18), new java.awt.Color(214, 48, 49))); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(240, 240));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 83, 422, 270));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/rsz_1logo_axia_copy.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, -1, -1));

        jTextField4.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 44, 340, 28));

        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel10.setText("NO FORM");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 49, -1, -1));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HARGA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 14), new java.awt.Color(214, 48, 49))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 405, 732, 60));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_icons_photo_1564522.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 410, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//    String jenisKen = (String) jComboBox1.getSelectedItem();
    String noform = jTextField4.getText();
    if (JOptionPane.showConfirmDialog(null,"Apakah Data Sudah Benar? ", 
            "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        this.setVisible(true);
    }
    try{
        String jrxmlFile = "C:\\Users\\Singgih\\Desktop\\Aplikasi Parkir Axia\\"
                + "Aplikasi Parkir Axia\\src\\laporantiket\\report1.jrxml";
        Connection kon = koneksiDB.getConnection();
        HashMap param = new HashMap();
        param.put("noform", noform);
        JasperReport JRpt =  JasperCompileManager.compileReport(jrxmlFile);
        JasperPrint JPrint = JasperFillManager.fillReport(JRpt, param, kon);
        JasperViewer.viewReport(JPrint, false);
            //            JasperPrintManager.printReport(JPrint,false);
            clear();
            nomorForm();
    }
    catch(JRException e){
        JOptionPane.showMessageDialog(rootPane, e);
    } catch (SQLException ex) {
        Logger.getLogger(lossTicket.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //capture foto
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        String noform = jTextField4.getText();
//        String nopol = jTextField1.getText();
        int min = 1;
        Random randomNum = new Random();
        int fotonumber = min + randomNum.nextInt();
        try {
            VideoCapture camera1 = new VideoCapture(2);
            Connection kon = koneksiDB.getConnection();
            PreparedStatement ps = kon.prepareStatement("update tiket_hilang set foto_stnk=? where no_form =?");
                if (!camera1.isOpened()) {
                    JOptionPane.showMessageDialog(null,  "Camera Error!");
                } else {
                    Mat frame = new Mat();
                    while(true) {
                        if (camera1.read(frame)) {
                        Highgui.imwrite("stnk"+fotonumber+".jpg", frame);
                        InputStream tampil = new FileInputStream ("C:\\Users\\"
                                + "Singgih\\Desktop\\Aplikasi Parkir Axia\\Aplikasi Parkir Axia\\stnk"+fotonumber+".jpg");
                        InputStream inputDB = new FileInputStream ("C:\\Users\\"
                                + "Singgih\\Desktop\\Aplikasi Parkir Axia\\Aplikasi Parkir Axia\\stnk"+fotonumber+".jpg");
                        BufferedImage img = ImageIO.read(tampil);
                        ImageIcon image = new ImageIcon(img);
                        Image im = image.getImage();
                        Image myImg = im.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                        ImageIcon newImage = new ImageIcon(myImg);
                        jLabel3.setIcon(newImage);
                        ps.setBlob(1, inputDB);
                        ps.setString(2, noform);
                        ps.executeUpdate();
                        break;
                        }
                    } 
                } 
                camera1.release();
            } 
            catch (HeadlessException | IOException | SQLException E){
                JOptionPane.showMessageDialog(null, "Error 102");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Capture foto 2
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        String nopol = jTextField1.getText();
        String noform = jTextField4.getText();
        try {
            VideoCapture camera2 = new VideoCapture(2);
            int min = 1;
            Random randomNum = new Random();
            int fotonumber = min + randomNum.nextInt();
            Connection con = koneksiDB.getConnection();
            PreparedStatement ps = con.prepareStatement("update tiket_hilang set foto_ktp=? where no_form =?");
            if (!camera2.isOpened()) {
                JOptionPane.showMessageDialog(null, "Camera Error");
            } else {
                Mat frame2 = new Mat();
                while(true) {
                    if (camera2.read(frame2)) {
                        Highgui.imwrite("ktp"+fotonumber+".jpg", frame2);
                        InputStream tampil = new FileInputStream ("C:\\Users\\"
                                + "Singgih\\Desktop\\Aplikasi Parkir Axia\\Aplikasi Parkir Axia\\ktp"+fotonumber+".jpg");
                        InputStream inputDB = new FileInputStream ("C:\\Users\\"
                                + "Singgih\\Desktop\\Aplikasi Parkir Axia\\Aplikasi Parkir Axia\\ktp"+fotonumber+".jpg");
                        BufferedImage img2 = ImageIO.read(tampil);
                        ImageIcon image = new ImageIcon(img2);
                        Image im = image.getImage();
                        Image myImg = im.getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(),Image.SCALE_SMOOTH);
                        ImageIcon newImage = new ImageIcon(myImg);
                        jLabel4.setIcon(newImage);
                        ps.setBlob(1, inputDB);
                        ps.setString(2, noform);
                        ps.executeUpdate();
                        break;
                    }
                }
            } camera2.release();
        } catch (HeadlessException | IOException | SQLException E) {
            JOptionPane.showMessageDialog(null, "Error 102");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // capture sim
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        String nopol = jTextField1.getText();
        String noform = jTextField4.getText();
        try {
            VideoCapture camera3 = new VideoCapture(2);
            int min = 1;
            Random randomNum = new Random();
            int fotonumber = min + randomNum.nextInt();
            Connection con = koneksiDB.getConnection();
            PreparedStatement ps = con.prepareStatement("update tiket_hilang set foto_sim=? where no_form=?");
            if (!camera3.isOpened()) {
                JOptionPane.showMessageDialog(null, "Camera Error");
            } else {
                Mat frame = new Mat();
                while(true) {
                    if (camera3.read(frame)) {
                        Highgui.imwrite("sim"+fotonumber+".jpg", frame);
                        InputStream tampil = new FileInputStream ("C:\\Users\\"
                                + "Singgih\\Desktop\\Aplikasi Parkir Axia\\Aplikasi Parkir Axia\\sim"+fotonumber+".jpg");
                        InputStream inputDB = new FileInputStream ("C:\\Users\\"
                                + "Singgih\\Desktop\\Aplikasi Parkir Axia\\Aplikasi Parkir Axia\\sim"+fotonumber+".jpg");
                        BufferedImage img3 = ImageIO.read(tampil);
                        ImageIcon image = new ImageIcon(img3);
                        Image im = image.getImage();
                        Image myImg = im.getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon newImage = new ImageIcon(myImg);
                        jLabel7.setIcon(newImage);
                        ps.setBlob(1, inputDB);
                        ps.setString(2, noform);
                        ps.executeUpdate();
                        break;
                    }
                }
            } camera3.release();
        } catch (HeadlessException | IOException | SQLException E) {
            JOptionPane.showMessageDialog(null, "Error 101");
            Logger.getLogger(lossTicket.class.getName()).log(Level.SEVERE, null, E);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // metode input keytyped
        String limit = jTextField3.getText();
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c==KeyEvent.VK_BACKSPACE) || c==KeyEvent.VK_DELETE)) {
            evt.consume(); 
        } else if (limit.length() == 4 || c==KeyEvent.VK_BACKSPACE || c==KeyEvent.VK_DELETE) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        //maksimum nomor plat
        String limit = jTextField1.getText();
        char c = evt.getKeyChar();
        if (limit.length() == 8 || c==KeyEvent.VK_BACKSPACE || c==KeyEvent.VK_DELETE) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //fungsi untuk catch jika data yang di isi kosong
        String s = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        if (jTextField1.getText().equals("") || jTextField2.getText().equals("") ||
                jTextField3.getText().equals("") || s.equals("")) {
            JOptionPane.showMessageDialog(null, "Mohon Mengisi Data Yang Masih Kosong", "Perhatian!!", JOptionPane.ERROR_MESSAGE);
        } else {
        getDendaTiket();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //perintah untuk default tampilan awal
        clear();
        nomorForm();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //
        getFoto();
    }//GEN-LAST:event_jButton8ActionPerformed

    public static void main(String args[]) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lossTicket().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    public void panggilDBKendaraan(){
        try {
            Connection con = koneksiDB.getConnection();
            String query = "SELECT * FROM harga_kendaraan";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                Object[] obj = new Object[5];
                obj[0] = rs.getString(1);
                obj[1] = rs.getString(2);
                obj[2] = rs.getString(3);
                obj[3] = rs.getInt(4);
                obj[4] = rs.getInt(5);
                jComboBox1.addItem((String) obj[1]);
            }
            rs.last();
            int jumlahdata = rs.getRow();
            rs.first();
        } catch (SQLException e) {
        }
    }
   public void getDendaTiket() {
        try {
//mengambil data dari database berdasarkan tipe kendaraan yang dipilih
            Connection c = koneksiDB.getConnection();
            Statement st = c.createStatement();
            String sql = "Select * from harga_kendaraan where jenis_kendaraan ='"+jComboBox1.getSelectedItem()+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
//menjadikan data yang diambil dari tipe kendaraan yang dipilih menjadi object
                Object ob[] = new Object[4];
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                ob[2] = rs.getInt(3);
                ob[3] = rs.getInt(4);
                //konversi data dari database kedalam program java
                int dendaTiket = (Integer) ob[3];
                int hargaKendaraan = (Integer) ob[2];
                noIden = jTextField2.getText();
                Object jenisKendaraan = jComboBox1.getSelectedItem();
                Graphics bs = jLabel3.getGraphics();
                //fungsi untuk mengambil nilai jam/menit/detik 
                DateFormat jamMenit = new SimpleDateFormat("HHmm");
                String inputJam = jTextField3.getText();
                Date date = (Date)jamMenit.parse(inputJam);
                String getJamMenit = new SimpleDateFormat("HH:mm:ss").format(date);
                //fungsi untuk mengambil nilai tahun/bulan/hari
                SimpleDateFormat tglBulan = new SimpleDateFormat("yyyy-MM-dd");
                String getTglBulan = tglBulan.format(jDateChooser1.getDate());
                //fungsi untuk mengambil nilai keduanya
                String tglmasuk = ("" + getTglBulan +" "+ getJamMenit);
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date tglmasuk2 = format.parse(tglmasuk);
                //fungsi untuk mengambil tanggal dan jam skrg
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
                Date curTime = new Date();
                //fungsi untuk membuat perhitungan selisih jam masuk dan jam keluar
                long diff = Math.abs(curTime.getTime()) - Math.abs(tglmasuk2.getTime());
                long diffHours = diff / (60 * 60 * 1000) % 24 ;
                long diffDays = diff / (24 * 60 * 60 * 1000);
                int hasilSelisih = (24 * (int) diffDays) + (int) diffHours;
                    if (hasilSelisih == 0) {
                        hasilSelisih = 1;
                    }
                    int tiket = hasilSelisih * hargaKendaraan;
                    int totalDenda = dendaTiket + tiket;
                    NumberFormat nf = NumberFormat.getInstance();
                    jLabel11.setText("Rp. " + nf.format(totalDenda));
                    //perintah untuk memasukan data ke db
                    String nopol = jTextField1.getText();
    //                String noform = jTextField4.getText();
                try {
                    Connection kon = koneksiDB.getConnection();
                    PreparedStatement ps = kon.prepareStatement("insert into tiket_hilang "
                            + "(plat_nomor, jenis_kendaraan, total_denda, tanggal_keluar, no_identitas) "
                            + "values (?,?,?,?,?)");
                    ps.setString(1, nopol);
                    ps.setObject(2, jenisKendaraan);
                    ps.setInt(3, totalDenda);
                    ps.setString(4, timeStamp);
                    ps.setString(5, noIden);
                    ps.executeUpdate();
                    jButton3.setEnabled(true);
                    jButton4.setEnabled(true);
                    jButton5.setEnabled(true);
                    jButton2.setEnabled(true);
                } catch (SQLException E) {
                    JOptionPane.showMessageDialog(rootPane, "Error QueryDatabase");
                    Logger.getLogger(lossTicket.class.getName()).log(Level.SEVERE, null, E);
                }
            }
        } 
        catch (ParseException | SQLException ex) {
            Logger.getLogger(lossTicket.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    public void cetakStruk() {
        String nopol = jTextField1.getText();
        try {
                String jrxmlFile = "src/laporantiket/strukDenda.jrxml";
                Connection c = koneksiDB.getConnection();
                HashMap param = new HashMap();
                param.put("plat", nopol);
                JasperReport JRpt =  JasperCompileManager.compileReport(jrxmlFile);
                JasperPrint JPrint = JasperFillManager.fillReport(JRpt, param, c);
                JasperViewer.viewReport(JPrint, false);
        //            JasperPrintManager.printReport(JPrint,false);
            }
            catch(JRException e){
                JOptionPane.showMessageDialog(rootPane, e);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
    }
    public void getFoto() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        String nopol = jTextField1.getText();
        String noform = jTextField4.getText();
        int min = 1;
        Random randomNum = new Random();
        int fotoNum = min + randomNum.nextInt();
        try {
            Connection con = koneksiDB.getConnection();
            PreparedStatement ps = con.prepareStatement("update tiket_hilang set foto_keluar=? where no_form=?");
            VideoCapture camKeluar = new VideoCapture(1);
            if(!camKeluar.isOpened()) {
                JOptionPane.showMessageDialog(null, "Camera Error!");
            } else {
                Mat frame = new Mat();
                    while(true){
                        if(camKeluar.read(frame)){
                            Highgui.imwrite("fotokeluar"+fotoNum+".jpg", frame);
                            InputStream inputDB = new FileInputStream("C:\\Users\\Singgih\\Desktop\\Aplikasi Parkir Axia"
                                + "\\Aplikasi Parkir Axia\\fotokeluar"+fotoNum+".jpg");
                            InputStream tampil = new FileInputStream("C:\\Users\\Singgih\\Desktop\\Aplikasi Parkir Axia"
                                + "\\Aplikasi Parkir Axia\\fotokeluar"+fotoNum+".jpg");
                            ps.setBlob(1, inputDB);
                            ps.setString(2, noform);
                            BufferedImage img2 = ImageIO.read(tampil);
                            ImageIcon image = new ImageIcon(img2);
                            Image im = image.getImage();
                            Image myImg = im.getScaledInstance(jLabel9.getWidth(), jLabel9.getHeight(),Image.SCALE_SMOOTH);
                            ImageIcon newImage = new ImageIcon(myImg);
                            jLabel9.setIcon(newImage);
                            ps.executeUpdate();
                            break;
                        }
                    }
            } camKeluar.release();
        }catch (HeadlessException | IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    public void clear() {
        jTextField1.setText(""); 
        jComboBox1.setSelectedIndex(0);
        jTextField2.setText(""); jTextField3.setText("");
        jLabel3.setIcon(null); jLabel4.setIcon(null);
        jLabel7.setIcon(null); jTextField1.setEditable(true);
        jTextField2.setEditable(true); jTextField3.setEditable(true);
        jComboBox1.setEditable(true); jButton3.setEnabled(false);
        jButton4.setEnabled(false); jButton5.setEnabled(false);
        jButton2.setEnabled(false); jLabel9.setIcon(null);
    }
    public void nomorForm() {
        jTextField4.setEditable(false);
        try {
        Connection con = koneksiDB.getConnection();
        Statement st = con.createStatement();
        String sql = "select * from tiket_hilang order by no_form DESC";
        ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String kode = rs.getString("no_form");
                String kode2 = "" + (Integer.parseInt(kode) + 1);
                jTextField4.setText("" + kode2);
            } else {
                jTextField4.setText("1");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 101");
        }
    }
}
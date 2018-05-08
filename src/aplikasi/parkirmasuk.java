package aplikasi;

//import library
import com.util.FormUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.Timer;
import java.sql.*;
import javax.swing.JOptionPane;
import koneksi.koneksiDB;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import com.onbarcode.barcode.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.*;
import net.sf.jasperreports.engine.JasperPrintManager;
//import java.util.logging.Logger;
import net.sourceforge.barbecue.linear.code128.Code128Barcode;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

public class parkirmasuk extends javax.swing.JInternalFrame {

//deklarasi variable
private String noker="", nokar="", jeken="", jamsuk="", tmasuk=""; 
        int id=0;
private Connection conn;
private Statement st;
private String sql ="";
private String sql2 ="";
//    private boolean noid;
    private void KoneksiDB (){//koneksi database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/axia_parkir", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
        }
    }
    public void AutoKodeKarcis(){//auto kode karcis
        try {
            NoTiket.setEditable(false);
            Connection c=koneksiDB.getConnection();
            Statement s= c.createStatement();
            String sql = "SELECT * FROM parkir_keluar ORDER BY id DESC";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                String kd_id = rs.getString("id").substring(1);
                String AN = "" + (Integer.parseInt(kd_id) + 1);
                String Nol = "";
                
                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                java.util.Date now = new java.util.Date();
       SimpleDateFormat smpdtfmt = new SimpleDateFormat("MMyy", Locale.getDefault());
       String tanggal = smpdtfmt.format(now);
       SimpleDateFormat smpdtfmt1 = new SimpleDateFormat("dd", Locale.getDefault());
       String tanggal1 = smpdtfmt1.format(now);
       
       String nol_jam = "", nol_menit = "",nol_detik = "";

       java.util.Date dateTime = new java.util.Date();
       int nilai_jam = dateTime.getHours();
       int nilai_menit = dateTime.getMinutes();
       int nilai_detik = dateTime.getSeconds();
        
       if(nilai_jam <= 9) nol_jam= "0";
       if(nilai_menit <= 9) nol_menit= "0";
       if(nilai_detik <= 9) nol_detik= "0";
       String jam = nol_jam + Integer.toString(nilai_jam);
       String menit = nol_menit + Integer.toString(nilai_menit);
       String detik = nol_detik + Integer.toString(nilai_detik);
       
       NoTiket.setText(jam + tanggal +Nol + AN +  tanggal1 + menit);
                
            } else {
                java.util.Date now = new java.util.Date();
       SimpleDateFormat smpdtfmt = new SimpleDateFormat("MMyy", Locale.getDefault());
       String tanggal = smpdtfmt.format(now);
       SimpleDateFormat smpdtfmt1 = new SimpleDateFormat("dd", Locale.getDefault());
       String tanggal1 = smpdtfmt1.format(now);
       
       String nol_jam = "", nol_menit = "",nol_detik = "";

       java.util.Date dateTime = new java.util.Date();
       int nilai_jam = dateTime.getHours();
       int nilai_menit = dateTime.getMinutes();
       int nilai_detik = dateTime.getSeconds();
        
       if(nilai_jam <= 9) nol_jam= "0";
       if(nilai_menit <= 9) nol_menit= "0";
       if(nilai_detik <= 9) nol_detik= "0";
       String jam = nol_jam + Integer.toString(nilai_jam);
       String menit = nol_menit + Integer.toString(nilai_menit);
       String detik = nol_detik + Integer.toString(nilai_detik);
       NoTiket.setText(jam + tanggal +"0001" +  tanggal1 + menit);
//                NoTiket.setText("P0001");
//sesuaikan dengan variable namenya
               
            }
            rs.close();
            s.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    void showTime() {    
        new Timer (0, new ActionListener() {
            //menentukan jam masuk berdasarkan waktu real
            @Override
            public void actionPerformed (ActionEvent e) {
                Date d = new Date ();
                SimpleDateFormat s = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
                JamMasuk.setText(s.format(d));
            }
        }).start();
    }
    public parkirmasuk() {//    pemanggilan method
        initComponents();
        KoneksiDB();
        showTime();
        AutoKodeKarcis();
        FormUtil.centerWindow(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NoTiket = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JamMasuk = new javax.swing.JTextField();
        Submit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(240, 149, 105));
        setBorder(null);

        jPanel2.setBackground(new java.awt.Color(133, 149, 242));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel1.setText("NOMOR TIKET");

        NoTiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoTiketActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel4.setText("JAM MASUK");

        JamMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JamMasukActionPerformed(evt);
            }
        });

        Submit.setBackground(new java.awt.Color(51, 51, 51));
        Submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/resources/OK.png"))); // NOI18N
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/resources/Exit.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(Submit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JamMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(NoTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(13, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(NoTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(JamMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Submit)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JamMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JamMasukActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_JamMasukActionPerformed

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        //deklarasi fungsi variable
        try {
            NoTiket.setEditable(false);
            Connection c=koneksiDB.getConnection();
            Statement s= c.createStatement();
            String sql = "SELECT * FROM parkir_keluar ORDER BY id DESC";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                String kd_id = rs.getString("id").substring(1);
                String AN = "" + (Integer.parseInt(kd_id) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                java.util.Date now = new java.util.Date();
                SimpleDateFormat smpdtfmt = new SimpleDateFormat("MMyy", Locale.getDefault());
                String tanggal = smpdtfmt.format(now);
                SimpleDateFormat smpdtfmt1 = new SimpleDateFormat("dd", Locale.getDefault());
                String tanggal1 = smpdtfmt1.format(now);
                String nol_jam = "", nol_menit = "",nol_detik = "";
                java.util.Date dateTime = new java.util.Date();
                int nilai_jam = dateTime.getHours();
                int nilai_menit = dateTime.getMinutes();
                int nilai_detik = dateTime.getSeconds();
                if(nilai_jam <= 9) nol_jam= "0";
                if(nilai_menit <= 9) nol_menit= "0";
                if(nilai_detik <= 9) nol_detik= "0";
                String jam = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);
                NoTiket.setText(jam+tanggal+ Nol + AN+tanggal1+menit);//sesuaikan dengan variable namenya
                
            } else {
                java.util.Date now = new java.util.Date();
                SimpleDateFormat smpdtfmt = new SimpleDateFormat("MMyy", Locale.getDefault());
                String tanggal = smpdtfmt.format(now);
                SimpleDateFormat smpdtfmt1 = new SimpleDateFormat("dd", Locale.getDefault());
       String tanggal1 = smpdtfmt1.format(now);
       
       String nol_jam = "", nol_menit = "",nol_detik = "";

       java.util.Date dateTime = new java.util.Date();
       int nilai_jam = dateTime.getHours();
       int nilai_menit = dateTime.getMinutes();
       int nilai_detik = dateTime.getSeconds();
        
       if(nilai_jam <= 9) nol_jam= "0";
       if(nilai_menit <= 9) nol_menit= "0";
       if(nilai_detik <= 9) nol_detik= "0";
       String jam = nol_jam + Integer.toString(nilai_jam);
       String menit = nol_menit + Integer.toString(nilai_menit);
       String detik = nol_detik + Integer.toString(nilai_detik);
       NoTiket.setText(tanggal+"0001"+tanggal1);//sesuaikan dengan variable namenya   
            }
            rs.close();
            s.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }        
//        noker = String.valueOf(NoPlat.getText());
        nokar = String.valueOf(NoTiket.getText());
//        jeken = String.valueOf(JenisKendaraan.getSelectedItem());
        jamsuk = String.valueOf(JamMasuk.getText());
        //memasukkan harga ke database berdasarkan jenis kendaraan
//        int bharga = 0;
//        if (JenisKendaraan.getSelectedItem()=="MOTOR"){
//            bharga = 2000;
//        } else if (JenisKendaraan.getSelectedItem()=="MOBIL"){
//            bharga = 3000;
//        } else if (JenisKendaraan.getSelectedItem()=="MOBIL BOX"){
//            bharga = 4000;
//        }
  
        try {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    	VideoCapture camera = new VideoCapture(1);
    	int max = 1;
        int min = 10000;
        Random randomNum = new Random();
        int a = min + randomNum.nextInt();
        Connection kon = DriverManager.getConnection("jdbc:mysql://localhost:3306/axia_parkir","root","");
        PreparedStatement ps = kon.prepareStatement("insert into parkir_keluar(id, nomor_karcis, jam_masuk, fotomasuk) values(?,?,?,?)");
        if(!camera.isOpened()){
    		System.out.println("Error");
    	}
    	else {
    		Mat frame = new Mat();
    	    while(true){
    	    	if (camera.read(frame)){
                        System.out.println("Captured Frame Width " + 
    	    		frame.width() + " Height " + frame.height());
    	    		Highgui.imwrite("camera"+a+".jpg", frame);
                        boolean b = Highgui.imwrite("camera"+a+".jpg", frame);
                        InputStream is = new FileInputStream("C:\\Users\\Singgih\\Desktop\\Aplikasi Parkir Axia\\Aplikasi Parkir Axia\\camera"+a+".jpg");
                        
//                        sql = "INSERT INTO parkir_keluar (id, nomor_karcis, jam_masuk, fotomasuk)value" +
//                        " ('"+ id +"','"+ nokar +"','"+ jamsuk +"','"+ b +"')";
//                        st=conn.createStatement();
//                        st.executeUpdate(sql);
                        ps.setInt(1, id);
                        ps.setString(2, nokar);
                        ps.setString(3, jamsuk);
                        ps.setBlob(4, is);
                        ps.executeUpdate();
                        break;
    	    	}
    	    }	
    	}
    	camera.release();
            //syntax query sql untuk input ke database
           
//            JOptionPane.showMessageDialog(null,"Data Berhasil Di Input");
//            System.out.println(bharga);
           
            AutoKodeKarcis();}
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
        } catch (FileNotFoundException ex) {
        Logger.getLogger(parkirmasuk.class.getName()).log(Level.SEVERE, null, ex);
    }
        try{
            String jrxmlFile = "src/laporantiket/tiket.jrxml";
            Connection c = koneksiDB.getConnection();
            HashMap param = new HashMap();
            param.put("no", nokar);
            JasperReport JRpt =  JasperCompileManager.compileReport(jrxmlFile);
            JasperPrint JPrint = JasperFillManager.fillReport(JRpt, param,c);
//            JasperViewer.viewReport(JPrint, false);
            JasperPrintManager.printReport(JPrint,false);
        }
        catch(JRException e){
            JOptionPane.showMessageDialog(rootPane, e);
        } catch (SQLException ex) {
        Logger.getLogger(parkirmasuk.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_SubmitActionPerformed

    private void NoTiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoTiketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoTiketActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JamMasuk;
    private javax.swing.JTextField NoTiket;
    private javax.swing.JButton Submit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables


}

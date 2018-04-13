package aplikasi;

//import library
import com.util.FormUtil;
import java.awt.Toolkit;
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
import java.util.logging.*;
//import java.util.logging.Logger;
import net.sourceforge.barbecue.linear.code128.Code128Barcode;

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
    public void AutoKodePegawai(){//auto kode karcis
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
    private void clear() {
        NoPlat.setText("");
    }
    public parkirmasuk() {//    pemanggilan method
        initComponents();
        KoneksiDB();
        showTime();
        AutoKodePegawai();
        FormUtil.centerWindow(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NoTiket = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        NoPlat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JenisKendaraan = new javax.swing.JComboBox<>();
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

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel2.setText("NOMOR PLAT");

        NoPlat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoPlatActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel3.setText("JENIS KENDARAAN");

        JenisKendaraan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MOTOR", "MOBIL", "MOBIL BOX" }));
        JenisKendaraan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JenisKendaraanActionPerformed(evt);
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
                    .addComponent(NoTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(Submit)
                        .addGap(48, 48, 48)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(JenisKendaraan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JamMasuk, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(NoPlat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(NoTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JenisKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JamMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
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

    private void NoPlatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoPlatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoPlatActionPerformed

    private void JenisKendaraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JenisKendaraanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JenisKendaraanActionPerformed

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
       NoTiket.setText(jam+tanggal+"0001"+tanggal1+menit);//sesuaikan dengan variable namenya   
            }
            rs.close();
            s.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }        
        noker = String.valueOf(NoPlat.getText());
        nokar = String.valueOf(NoTiket.getText());
        jeken = String.valueOf(JenisKendaraan.getSelectedItem());
        jamsuk = String.valueOf(JamMasuk.getText());
        //memasukkan harga ke database berdasarkan jenis kendaraan
        int bharga = 0;
        if (JenisKendaraan.getSelectedItem()=="MOTOR"){
            bharga = 2000;
        } else if (JenisKendaraan.getSelectedItem()=="MOBIL"){
            bharga = 3000;
        } else if (JenisKendaraan.getSelectedItem()=="MOBIL BOX"){
            bharga = 4000;
        }
        try {
            //syntax query sql untuk input ke database
            sql = "INSERT INTO parkir_keluar (id, nomor_kendaraan, nomor_karcis, jenis_kendaraan, jam_masuk, harga_kendaraan)value" +
            " ('"+ id +"','"+ noker +"','"+ nokar +"','"+ jeken +"','"+ jamsuk +"','"+ bharga +"')";
            st=conn.createStatement();
            st.execute(sql);
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Input");
            System.out.println(bharga);
            clear();
            AutoKodePegawai();}
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
        }
        try{
            String jrxmlFile = "src/laporantiket/tiket.jrxml";
            Connection c = koneksiDB.getConnection();
            HashMap param = new HashMap();
            param.put("no", nokar);
            JasperReport JRpt =  JasperCompileManager.compileReport(jrxmlFile);
            JasperPrint JPrint = JasperFillManager.fillReport(JRpt, param,c);
            JasperViewer.viewReport(JPrint, false);
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
    private javax.swing.JComboBox<String> JenisKendaraan;
    private javax.swing.JTextField NoPlat;
    private javax.swing.JTextField NoTiket;
    private javax.swing.JButton Submit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables


}

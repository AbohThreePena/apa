package aplikasi;

import com.util.FormUtil;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.koneksiDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class parkirkeluar extends javax.swing.JInternalFrame {

    private Statement st;
    private ResultSet tampil;
    
    public parkirkeluar() {
        initComponents();
        FormUtil.centerWindow(this);
        showTime();
    }
    public static String hargaparkir() throws SQLException {
            String TotalBayar ="";
            ResultSet rs = null;
            Connection c=koneksiDB.getConnection();
            Statement s= c.createStatement();
            String sql = "SELECT harga_kendaraan FROM login_data2";
            rs = s.executeQuery(sql);
            String hp = rs.getString("harga_kendaraan");
            int d = Integer.parseInt(HargaKendaraan.getText());
            int e = Integer.parseInt(LamaParkir.getText());
            int hasilnya = d*e;
//        jTextField1.setText(""+hasilnya);
        return null;
    } 
//fungsi untuk menampilkan real time untuk text area jam keluar
    private void showTime() {    
        new Timer (0, new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                java.util.Date d = new java.util.Date ();
                SimpleDateFormat s = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
                JamKeluar.setText(s.format(d));
            }
        }).start();
    }
    //koneksi database
    private static Connection koneksi;
    public static Connection getConnection() throws SQLException {
        if(koneksi==null){
           try {
               String url = "jdbc:mysql://localhost:3306/axia_parkir";
               String usr = "root";
               String pwd = "";
               DriverManager.registerDriver(new com.mysql.jdbc.Driver());
               koneksi = DriverManager.getConnection(url, usr, pwd);
           } catch(SQLException ex) {
               Logger.getLogger(koneksiDB.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
        return koneksi;
}

public class Function{
       Connection con = null;
       ResultSet rs = null;
       PreparedStatement ps = null;
       public ResultSet find(String s){
           try{
           con = koneksiDB.getConnection();
           ps = con.prepareStatement("select * from parkir_keluar where nomor_karcis = ?");
           ps.setString(1,s);
           rs = ps.executeQuery();
           }catch(SQLException ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
       }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        JamKeluar = new javax.swing.JTextField();
        LamaParkir = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        NoKendaraan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        SaveInput = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        NoKarcis = new javax.swing.JTextField();
        HargaKendaraan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JenisKendaraan = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("JAM KELUAR");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        JamKeluar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JamKeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JamKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JamKeluarActionPerformed(evt);
            }
        });

        LamaParkir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LamaParkir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LamaParkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamaParkirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("NOMOR KENDARAAN");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        NoKendaraan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NoKendaraan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NoKendaraan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoKendaraanActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("DURASI PARKIR");

        submit.setBackground(new java.awt.Color(240, 217, 149));
        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/resources/Add.png"))); // NOI18N
        submit.setText("PROSES");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        SaveInput.setBackground(new java.awt.Color(240, 217, 149));
        SaveInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/resources/OK.png"))); // NOI18N
        SaveInput.setText("BAYAR");
        SaveInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveInputActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("NOMOR KARCIS PARKIR");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton3.setBackground(new java.awt.Color(240, 217, 149));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/resources/door_out.png"))); // NOI18N
        jButton3.setText("CLOSE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        NoKarcis.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NoKarcis.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("JENIS KENDARAAN");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("HARGA KENDARAAN");

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel1.setText("PEMBAYARAN PARKIR KELUAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(JamKeluar)
                        .addComponent(LamaParkir)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(93, 93, 93)
                            .addComponent(submit)
                            .addGap(27, 27, 27)
                            .addComponent(SaveInput, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(jButton3))
                        .addComponent(jLabel4)
                        .addComponent(jLabel2)
                        .addComponent(NoKarcis)
                        .addComponent(NoKendaraan)
                        .addComponent(JenisKendaraan)
                        .addComponent(jLabel6)
                        .addComponent(HargaKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addContainerGap(13, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NoKarcis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NoKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JenisKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JamKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LamaParkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HargaKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submit)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

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

    private void NoKendaraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoKendaraanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoKendaraanActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        //membuat fungsi untuk submit
    //membuat fungsi untuk submit    
    Function g = new Function();
    ResultSet rs = null;
    String hp = "";
    rs = g.find(NoKarcis.getText());//find berdasarkan nomor plat
    try {
        if(rs.next()) {
            NoKendaraan.setText(rs.getString("nomor_kendaraan"));
            JenisKendaraan.setText(rs.getString("jenis_kendaraan"));
            HargaKendaraan.setText(rs.getString("harga_kendaraan"));
        } else {
            JOptionPane.showMessageDialog(null, "Tidak Ada Kendaraan Ini");
        }
    } catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
    try {
        //perhitungan selisih total jam lama parkir
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = null;
        Date d2 = null;
//        String dateStart = "Select jam_masuk from parkir_keluar where nomor_karcis '"+NoKarcis+"'";
        String dateStart = rs.getString("jam_masuk");
        String dateStop  = JamKeluar.getText();
        
        ResultSet rst = null;
        d1 = format.parse(dateStart);
        d2 = format.parse(dateStop);
        long diff = Math.abs(d2.getTime()) - Math.abs(d1.getTime());
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24 ;
        long diffDays = diff / (24 * 60 * 60 * 1000);

        int b = (int) diffDays;
        int c = (int) diffHours;
        int hasilSelisih = (24 * (int) diffDays) + (int) diffHours;
            if (hasilSelisih < 1) {
                hasilSelisih = 1;
            }
        String totaljam = Integer.toString(hasilSelisih);
        //untuk tampilan jam dan menit di text di laporan pintu keluar
//        String totaljam2 = Integer.toString((int) diffHours);
//        String totaljam3 = Integer.toString((int) diffMinutes);
//        LamaParkir.setText(totaljam2 + " Jam " + totaljam3 + " Menit");
        LamaParkir.setText(totaljam);
    } catch(Exception ex) {
        JOptionPane.showMessageDialog(null,"Error "+ex.getMessage());
    }
    
    }//GEN-LAST:event_submitActionPerformed

    private void JamKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JamKeluarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_JamKeluarActionPerformed

    private void LamaParkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamaParkirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LamaParkirActionPerformed

    private void SaveInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveInputActionPerformed
        //perintah untuk input hasil ke database yang sudah di lengkapi
        String TotalBayar = "";    

        try
        {
            int d = Integer.parseInt(HargaKendaraan.getText());
            int e = Integer.parseInt(LamaParkir.getText());
            int hasilnya = d*e;
            if (hasilnya > 10000) {
                hasilnya = 10000;
            }
            TotalBayar = (""+hasilnya);
            // create a java mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/axia_parkir";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");
            // create the java mysql update preparedstatement
            String query = "update parkir_keluar set jam_keluar =?, lama_parkir =?, total_bayar =? where nomor_kendaraan ='"+NoKendaraan.getText()+"'";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, JamKeluar.getText());
            preparedStmt.setString(2, LamaParkir.getText());
            preparedStmt.setString(3, TotalBayar);
            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            conn.close();
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        try {
            totalBayar tb = new totalBayar();
            tb.setVisible(true); 
        } catch (Exception E) {
            JOptionPane.showMessageDialog(rootPane, closable);
        }
    try {
                //clear area text
        NoKendaraan.setText("");
        NoKarcis.setText("");
        JenisKendaraan.setText("");
        JamKeluar.setText("");
        LamaParkir.setText("");
        HargaKendaraan.setText("");
    } catch(Exception E){
        JOptionPane.showMessageDialog(rootPane, "Gagal");
    }
    }//GEN-LAST:event_SaveInputActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField HargaKendaraan;
    public static javax.swing.JTextField JamKeluar;
    public static javax.swing.JTextField JenisKendaraan;
    public static javax.swing.JTextField LamaParkir;
    public static javax.swing.JTextField NoKarcis;
    public static javax.swing.JTextField NoKendaraan;
    private javax.swing.JButton SaveInput;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}

package aplikasi;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import koneksi.koneksiDB;
import java.lang.String;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Random;
import javax.swing.ImageIcon;
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
import net.sf.jasperreports.engine.JasperPrintManager;

public class menu extends javax.swing.JFrame {
    String namapegawai = userakses.getU_nama();
    String kodepegawai = userakses.getU_kodePegawai();
    String leveluser = userakses.getU_levelUser();
//    Byte fotopegawai = userakses.getU_fotoUser();
    
    public menu(){
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        setJam();
        setTanggal();
        jenisKendaraan();
        jPanel5.setBackground(new Color(0,0,0,70));
        jTextField1.setEditable(false);
        jLabel14.setText(namapegawai);
        jLabel16.setText(kodepegawai);
        jLabel15.setText(leveluser);
        tampilfoto();
    }
    public void clear() {
        jTextField2.setText("");
        jTextField1.setText("");
        jTextField3.setText("0");
    }
    
    public int getDurasi(Timestamp jmmasuk, Date jmkeluar){
//        String d1 = null;
//        d1 = jmmasuk.toString();
        long diff = Math.abs(jmkeluar.getTime()) - Math.abs(jmmasuk.getTime());
//        long diffSeconds = diff / 1000 % 60;
//        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24 ;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        int hasilSelisih = (24 * (int) diffDays) + (int) diffHours;
            if (hasilSelisih < 1) {
                hasilSelisih = 1;
            }        
        return hasilSelisih;  
    }
    public void tampilfoto() {
        try {
        Connection con = koneksiDB.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from login_data2 where id = '"+kodepegawai+"'");
            if(rs.next()){
                byte[] img = rs.getBytes("foto_pegawai");
                //Resize The ImageIcon
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(jLabel13.getWidth(), jLabel13.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                jLabel13.setIcon(newImage);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 101!");
        } catch (Exception f) {
            jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_87_111095.png")));
        }
    }
    public void jenisKendaraan(){
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
    public ResultSet getNomorKarcis(){
       Connection con = null;
       ResultSet rs = null;
           try{
            Connection c = koneksiDB.getConnection();
            Statement s  = c.createStatement();
            String sql   = "select * from parkir_keluar where nomor_karcis = '"+jTextField2.getText()+"'";
            rs = s.executeQuery(sql);
            rs.next();
           }catch(SQLException ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
    }
    public void hasilJenis2(){
            try {
                Connection con = koneksiDB.getConnection();
                String sql = "Select id, harga_kendaraan from harga_kendaraan where jenis_kendaraan ='"+jComboBox1.getSelectedItem()+"'";
                Statement stt = con.createStatement();
                ResultSet rss = stt.executeQuery(sql);
                while (rss.next()) {
                    Object[] ob = new Object[3];
                    ob[0] = rss.getString(1);
                    ob[1] = rss.getString(2);
                    String hasil = (String) ob[1];
                    } rss.close(); stt.close();
                } catch (SQLException E) {
                    JOptionPane.showMessageDialog(rootPane, E);
            }  
        }
    public void perhitungan() throws SQLException {
            Connection con = koneksiDB.getConnection();
            String sql = "Select id, harga_kendaraan, harga_maks_kend from harga_kendaraan where jenis_kendaraan ='"+jComboBox1.getSelectedItem()+"'";
            Statement stt = con.createStatement();
            ResultSet rss = stt.executeQuery(sql);
            while (rss.next()) {
                Object[] ob = new Object[4];
                ob[0] = rss.getString(1);
                ob[1] = rss.getInt(2);
                ob[2] = rss.getInt(3);
                Integer harga = (Integer)ob[1];
                Integer maks  = (Integer)ob[2];
//                int hargacvt = Integer.parseInt(harga);
                ResultSet rs = getNomorKarcis();
                Date jmkeluar = new Date();
                try {
                    jTextField1.setText(rs.getString("nomor_kendaraan"));
                    Timestamp jmmasuk = rs.getTimestamp("jam_masuk");
                    java.util.Date d = new java.util.Date();
                    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    int durasi = getDurasi(jmmasuk,jmkeluar);
            //            int total = rs.getInt(harga);
                    int totalbayar = durasi*harga;
                        if (totalbayar >= maks) {
                            totalbayar = maks;
                            if (maks == 0) {
                                totalbayar = durasi*harga;
                            }
                        }
                    NumberFormat nf = NumberFormat.getInstance();
                    jTextField3.setText(nf.format(totalbayar));
                } catch (SQLException ex) {
                    Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
    public void setJam(){
        ActionListener taskPerformer = new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                String nol_jam = "", nol_menit = "",nol_detik = "";
                java.util.Date dateTime = new java.util.Date();
                int nilai_jam = dateTime.getHours();
                int nilai_menit = dateTime.getMinutes();
                int nilai_detik = dateTime.getSeconds();
                if(nilai_jam <= 9) nol_jam= "0";
                if(nilai_menit <= 9) nol_menit= "0";
                if(nilai_detik <= 9) nol_detik= "0";
                String waktu = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);
                jLabel2.setText(waktu+":"+menit+":"+detik+"");
            }
        };
        new Timer(1000, taskPerformer).start();
    }
    public void setTanggal(){
    java.util.Date skrg = new java.util.Date();
    java.text.SimpleDateFormat kal = new
    java.text.SimpleDateFormat("dd/MM/yyyy");
    jLabel1.setText(kal.format(skrg));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Logout = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("File");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar1.add(jMenu4);

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Parkir Axia v1.0");
        setBackground(new java.awt.Color(41, 128, 185));
        setUndecorated(true);

        jDesktopPane2.setBackground(new java.awt.Color(41, 128, 185));
        jDesktopPane2.setPreferredSize(new java.awt.Dimension(1366, 768));
        jDesktopPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_aiga_taxi_134116.png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel5.setOpaque(true);
        jDesktopPane2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 165, 173));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_aiga_taxi_134116.png"))); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel8.setOpaque(true);
        jDesktopPane2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 110, 165, 173));

        jLabel9.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel9.setText("IN");
        jDesktopPane2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 70, 20, 30));

        jLabel10.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel10.setText("OUT");
        jDesktopPane2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 70, 40, 30));

        jPanel10.setBackground(new java.awt.Color(41, 128, 185));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setForeground(new java.awt.Color(102, 255, 255));

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel6.setText("NO POL");

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("TOTAL BAYAR");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField2.setFont(new java.awt.Font("Agency FB", 0, 32)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jComboBox1.setMaximumRowCount(3);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField3.setText("                                                               0");
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel11.setText("JENIS");

        jLabel12.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel12.setText("NO KARCIS");

        jPanel3.setBackground(new java.awt.Color(25, 42, 86));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("PT AXIA PRIMA SEJAHTERA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 966, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel4))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1))))
                .addGap(33, 33, 33))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(230, 230, 230)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jDesktopPane2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 660));

        jPanel1.setBackground(new java.awt.Color(25, 42, 86));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setOpaque(true);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logout.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        Logout.setText("LOGOUT");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jPanel1.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 88));

        jButton2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton2.setText("EXIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 11, 120, 88));

        jButton1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton1.setText("CETAK STRUK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 440, 80));

        jButton3.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton3.setText("LOST TICKET");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 110, 90));

        jDesktopPane2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 1370, 110));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(25, 42, 86));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setBackground(new java.awt.Color(41, 128, 185));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_87_111095.png"))); // NOI18N
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel13.setOpaque(true);

        jLabel14.setBackground(new java.awt.Color(204, 255, 204));
        jLabel14.setForeground(new java.awt.Color(204, 255, 204));
        jLabel14.setText("RIDZQY RACHDIANTO");

        jLabel15.setBackground(new java.awt.Color(204, 255, 204));
        jLabel15.setForeground(new java.awt.Color(204, 255, 204));
        jLabel15.setText("OPERATOR");

        jLabel16.setBackground(new java.awt.Color(204, 255, 204));
        jLabel16.setForeground(new java.awt.Color(204, 255, 204));
        jLabel16.setText("KP3100");

        jLabel17.setBackground(new java.awt.Color(204, 255, 204));
        jLabel17.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 255, 204));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("SELAMAT DATANG OPERATOR");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jDesktopPane2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 300, 380, 360));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel7.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("  APLIKASI PARKIR");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDesktopPane2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 380, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Fungsi untuk exit button
        int a = JOptionPane.showOptionDialog(null,"Do you want to exit ?","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
        if(a == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        //fungsi untuk logout button
        if (JOptionPane.showConfirmDialog(null,"Do you want to logout? ", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new frameLogin().setVisible(true);
        }
    }//GEN-LAST:event_LogoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Connection con = koneksiDB.getConnection();
            String sql = "Select id, harga_kendaraan from harga_kendaraan where jenis_kendaraan ='"+jComboBox1.getSelectedItem()+"'";
            Statement stt;
            try {
                stt = con.createStatement();
                ResultSet rss = stt.executeQuery(sql);
                while (rss.next()) {
                    Object[] ob = new Object[3];
                    ob[0] = rss.getString(1);
                    ob[1] = rss.getInt(2);
                    Integer harga = (Integer) ob[1];
//                    int hargacvt = Integer.parseInt(harga);
                    ResultSet rs = getNomorKarcis();
                    Timestamp jmmasuk = rs.getTimestamp("jam_masuk");
                    Date jmkeluar = new Date();
                    String jmkeluar2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(jmkeluar);
                    int durasi = getDurasi(jmmasuk,jmkeluar);
                    int totalbayar = durasi*harga;
                    java.util.Date d = new java.util.Date();
                    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            
                            String query = "update parkir_keluar set nomor_kendaraan = '" + jTextField1.getText() +
                                    "',jenis_kendaraan = '" + jComboBox1.getSelectedItem()+
                                    "',jam_keluar = '" + jmkeluar2 +
                                    "',lama_parkir = '" + durasi +
                                    "',total_bayar = '" + totalbayar +
                                    "' where nomor_karcis = '" + jTextField2.getText() + "'";
                            
                            Statement st=(Statement)con.createStatement();
                            st.executeUpdate(query);
                            st.close();
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            String nokar = jTextField2.getText();
            try{
                String jrxmlFile = "src/laporantiket/struk.jrxml";
                Connection c = koneksiDB.getConnection();
                HashMap param = new HashMap();
                param.put("karcis", nokar);
                JasperReport JRpt =  JasperCompileManager.compileReport(jrxmlFile);
                JasperPrint JPrint = JasperFillManager.fillReport(JRpt, param, c);
                JasperViewer.viewReport(JPrint, false);
        //            JasperPrintManager.printReport(JPrint,false);
            }
            catch(JRException e){
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        clear();
        jTextField1.setEditable(false);
        jTextField2.setEditable(true);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_aiga_taxi_134116.png")));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // perintah jika ditekan enter pada text nomor tiket               
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
                try {
                    perhitungan();
                    Connection conn = koneksiDB.getConnection();
                    Statement stt = conn.createStatement();
                    ResultSet rsf = stt.executeQuery("select * from parkir_keluar where nomor_karcis = '"+jTextField2.getText()+"'");
                    if(rsf.next()){
                        byte[] img = rsf.getBytes("fotomasuk");
                        //Resize The ImageIcon
                        ImageIcon image = new ImageIcon(img);
                        Image im = image.getImage();
                        Image myImg = im.getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(),Image.SCALE_SMOOTH);
                        ImageIcon newImage = new ImageIcon(myImg);
                        jLabel5.setIcon(newImage);
                        jTextField2.setEditable(false);
                        jTextField1.setEditable(true);
                        jTextField1.requestFocus(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No Data");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            //foto saat kendaraan keluar
            try {
                VideoCapture camera = new VideoCapture(1);
                int min = 10000;
                Random randomNum = new Random();
                int a = min + randomNum.nextInt();
                Connection kon = koneksiDB.getConnection();
                PreparedStatement ps = kon.prepareStatement("update parkir_keluar set fotokeluar=? where nomor_karcis = '"+jTextField2.getText()+"'");
                Mat frame = new Mat();    
                if(!camera.isOpened() || !camera.read(frame)){
                        JOptionPane.showMessageDialog(this, "Mohon Cek Kamera Keluar!");
                    }
                    else {
                        while(true){
                                Highgui.imwrite("camera"+a+".jpg", frame);
                                InputStream is = new FileInputStream("C:\\Users\\Singgih\\Desktop\\Aplikasi Parkir Axia\\Aplikasi Parkir Axia\\camera"+a+".jpg");
                                ps.setBlob(1, is);
                                ps.executeUpdate();
                                break;
                        }
                    } camera.release();	
                }
            catch (Exception f) {
                    JOptionPane.showMessageDialog(rootPane, "Error");
                    }
             try{
                 Connection con = koneksiDB.getConnection();
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("select * from parkir_keluar where nomor_karcis = '"+jTextField2.getText()+"'");
                 if(rs.next()){
                     byte[] img = rs.getBytes("fotokeluar");
                     //Resize The ImageIcon
                     ImageIcon image = new ImageIcon(img);
                     Image im = image.getImage();
                     Image myImg = im.getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(),Image.SCALE_SMOOTH);
                     ImageIcon newImage = new ImageIcon(myImg);
                     jLabel8.setIcon(newImage);
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "No Data");
                 }
                 jTextField1.setEditable(true);
                 jTextField2.setEditable(false);
             }
             catch(Exception ex){
                 JOptionPane.showMessageDialog(null, "Error 201!");
             }
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        hasilJenis2();  
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // pemanggilan menu lost ticket
        lossTicket panggil = new lossTicket();
        panggil.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
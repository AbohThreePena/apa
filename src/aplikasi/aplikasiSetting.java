package aplikasi;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksiDB;
import com.util.FormUtil;
import java.text.NumberFormat;

public class aplikasiSetting extends javax.swing.JInternalFrame {
    private Connection con;
    private DefaultTableModel model;
    private String jeken=""; 
    private Integer harken=0, tiket=0, maks=0;

    public aplikasiSetting() {
        initComponents();
        ShowData();
        FormUtil.centerWindow(this);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
//        KoneksiDB();
    }
    
public void ShowData(){
        model = new DefaultTableModel();
        jTable1.setModel(model);
        model.addColumn ("NO");
        model.addColumn ("JEN. KENDARAAN");
        model.addColumn ("HARGA KENDARAAN");
        model.addColumn ("TIKET HILANG");
        model.addColumn ("HARGA MAX KEND.");
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
    try {            
            Connection c=koneksiDB.getConnection();
            Statement s= c.createStatement();
            String sql="Select * from harga_kendaraan";
            ResultSet r=s.executeQuery(sql);
            while (r.next()) {
                Object[] o=new Object[6];
                o[0]=r.getString("id");
                o[1]=r.getString("jenis_kendaraan");
                o[2]=r.getInt("harga_kendaraan");
                o[3]=r.getInt("tiket_hilang");
                o[4]=r.getInt("harga_maks_kend");
                model.addRow(o);
            }
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
    }
}
public void clear() {
    textJenisKendaraan.setText("");
    textHargaKendaraan.setText("");
    textDendaTiket.setText("");
    textHargaMaksimum.setText("");
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        textJenisKendaraan = new javax.swing.JTextField();
        textDendaTiket = new javax.swing.JTextField();
        textHargaKendaraan = new javax.swing.JTextField();
        textHargaMaksimum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBorder(null);
        setTitle("APLIKASI SETTING");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_Streamline-74_185094.png"))); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(600, 488));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(189, 195, 199));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HARGA KENDARAAN PER JAM");

        jPanel4.setBackground(new java.awt.Color(189, 195, 199));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(189, 195, 199));
        jButton1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jButton1.setText("TAMBAH");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 331, 182, 116));

        jButton3.setBackground(new java.awt.Color(189, 195, 199));
        jButton3.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton3.setText("DELETE");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 247, 86, 73));

        jButton2.setBackground(new java.awt.Color(189, 195, 199));
        jButton2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 247, 86, 73));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_money-3_322465.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 43, 182, 170));

        jButton4.setBackground(new java.awt.Color(189, 195, 199));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_close2_1814078 (2).png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 20, 21));

        textJenisKendaraan.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        textJenisKendaraan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        textDendaTiket.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        textDendaTiket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        textHargaKendaraan.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        textHargaKendaraan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        textHargaMaksimum.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        textHargaMaksimum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textHargaMaksimum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHargaMaksimumActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel2.setText("JEN. KENDARAAN");

        jLabel3.setFont(new java.awt.Font("Agency FB", 0, 22)); // NOI18N
        jLabel3.setText("HARGA KENDARAAN");

        jLabel5.setFont(new java.awt.Font("Agency FB", 0, 22)); // NOI18N
        jLabel5.setText("DENDA TIKET ");

        jLabel6.setFont(new java.awt.Font("Agency FB", 0, 22)); // NOI18N
        jLabel6.setText("HARGA MAKSIMUM");

        jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NO", "JEN. KENDARAAN", "HARGA KENDARAAN PERJAM", "TIKET HILANG", "HARGA MAX KEND."
            }
        ));
        jTable1.setPreferredSize(new java.awt.Dimension(100, 64));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(30);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(110);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(textJenisKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(textHargaKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(textDendaTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(textHargaMaksimum, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textJenisKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textHargaKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDendaTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textHargaMaksimum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane1.addTab("HARGA KENDARAAN", jPanel2);

        jPanel3.setBackground(new java.awt.Color(189, 195, 199));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CARA MENGISI HARGA PADA MENU APLIKASI SETTING");

        jLabel8.setText("3. JIKA ADA JENIS KENDARAAN YANG MAU DI GRATISKAN MAKA ISI DENGAN ANGKA 0 SEMUA PADA MENU HARGA KENDARAAN");

        jLabel9.setText("1.  PADA MENU HARGA KENDARAAN HARGA HARUS DI ISI SEMUA.");

        jLabel10.setText("2. ADA EMPAT BUAH HARGA YANG ADA DI MENU HARGA KENDARAAN");

        jLabel11.setText("5. JIKA KENDARAAN TIDAK ADA BATAS LIMIT HARGA PER JAM NYA, MAKA ISI DENGAN ANGKA 0.");

        jLabel12.setText("4. JIKA KENDARAAN ADA BATAS LIMIT UNTUK HARGA MAKA DI ISI DI KOLOM HARGA MAKSIMUM KENDARAAN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("BANTUAN", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // perintah untuk update data di database
        tiket = Integer.valueOf(textDendaTiket.getText());
        maks = Integer.valueOf(textHargaMaksimum.getText());
        harken = Integer.valueOf(textHargaKendaraan.getText());
        
        int slct = jTable1.getSelectedRow();
        String nomor = (String) model.getValueAt(slct, 0);
        
        if(textJenisKendaraan.getText().equals("")||textHargaKendaraan.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane,"Data Belum Lengkap","Perhatian",JOptionPane.WARNING_MESSAGE);
        }
        else{
            int i=jTable1.getSelectedRow();
            if(i==-1)
            {
                return;
            }
            try {
                Connection c=koneksiDB.getConnection();
                Statement st=(Statement)c.createStatement();
                String sql ="update harga_kendaraan set "
                        + "jenis_kendaraan = '" + textJenisKendaraan.getText() +"', harga_kendaraan = '" +harken+"', tiket_hilang ='"+tiket+"', harga_maks_kend ='"+maks+"' where id ='"+nomor+"'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane,"Data Berhasil Diubah");
                clear();
                st.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(rootPane,e);
            }finally{
                ShowData();
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);
                jButton1.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // perintah untuk delete data di database
        if(textJenisKendaraan.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane,"Data Belum Lengkap","Perhatian",
                JOptionPane.WARNING_MESSAGE);
        }
        else{
            int i=jTable1.getSelectedRow();
            if(i==-1)
            {
                return;
            }
            try {
                Connection c=koneksiDB.getConnection();
                Statement st=(Statement)c.createStatement();
                String sql = "DELETE From harga_kendaraan where jenis_kendaraan = '" + textJenisKendaraan.getText() + "'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane,"Data Berhasil Dihapus");
                clear();
                st.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(rootPane,e);
            }finally
            {
                ShowData();
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);
                jButton1.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // perintah untuk submit ke database
        
        if (textJenisKendaraan.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Mohon Isi Jenis Kendaraan!");
        } else if (textHargaKendaraan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mohon Isi Harga Kendaraan!");
        } else if (textDendaTiket.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mohon Isi Denda Tiket Kendaraan!"); 
        } else if (textHargaMaksimum.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Mohon Isi Harga Maksimum Kendaraan!");
        } else {
                try{
                    jeken  = textJenisKendaraan.getText();
                    harken = Integer.valueOf(textHargaKendaraan.getText());
                    tiket = Integer.valueOf(textDendaTiket.getText());
                    maks = Integer.valueOf(textHargaMaksimum.getText());
                    Connection c=koneksiDB.getConnection();
                    Statement s= c.createStatement();
                    String sql="INSERT INTO harga_kendaraan (jenis_kendaraan, harga_kendaraan, tiket_hilang, harga_maks_kend) value"
                    + "('"+ jeken +"','"+ harken +"','"+ tiket +"','"+ maks +"')";
                    s.execute(sql);
                    clear();
                    ShowData();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR \n Data Gagal Disimpan");
                } finally {
                    jButton2.setEnabled(false);
                    jButton3.setEnabled(false);
                }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int slct = jTable1.getSelectedRow();
        if (slct==-1) {
            return;
        }
        String jeken=(String) model.getValueAt(slct, 1);
        textJenisKendaraan.setText(jeken);
        
        Integer harken = (Integer) model.getValueAt(slct, 2);
        String harken2 = harken.toString();
        textHargaKendaraan.setText(harken2);
        
        Integer tiket=(Integer) model.getValueAt(slct, 3);
        String tiket2 = tiket.toString();
        textDendaTiket.setText(tiket2);
        
        Integer maks=(Integer) model.getValueAt(slct, 4);
        String maks2 = maks.toString();
        textHargaMaksimum.setText(maks2);
        
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        textJenisKendaraan.setText(null);
        textHargaKendaraan.setText(null);
        textDendaTiket.setText(null);
        textHargaMaksimum.setText(null);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void textHargaMaksimumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHargaMaksimumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHargaMaksimumActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textDendaTiket;
    private javax.swing.JTextField textHargaKendaraan;
    private javax.swing.JTextField textHargaMaksimum;
    private javax.swing.JTextField textJenisKendaraan;
    // End of variables declaration//GEN-END:variables
}

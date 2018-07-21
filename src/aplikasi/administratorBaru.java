package aplikasi;

import com.util.FormUtil;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.koneksiDB;

public class administratorBaru extends javax.swing.JInternalFrame {
   
    private DefaultTableModel model;
    private String sql=""; 
    private String usm="", 
            pas="", keter="", 
            ids="";
    private Object lvu="";
    String filename = null;
    byte[] personimage = null;
    
    public administratorBaru() {
        initComponents();
        ShowData();
        FormUtil.centerWindow(this);
        AutoKodePegawai();
        simpan.setEnabled(true);
        del.setEnabled(false);
        update.setEnabled(false);
    }
    //auto generate kode pegawai
    public void AutoKodePegawai(){
        try {
            kodepegawai.setEditable(false);
            Connection c=koneksiDB.getConnection();
            Statement s= c.createStatement();
            String sql = "SELECT * FROM login_data2 ORDER BY id DESC";
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
                kodepegawai.setText("P" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                kodepegawai.setText("P0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            s.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    //menampilkan data pegawai di tabel
    public void ShowData(){
        model = new DefaultTableModel();
        table.setModel(model);
        model.addColumn ("ID");
        model.addColumn ("Username");
        model.addColumn ("Password");
        model.addColumn ("Level User");
        model.addColumn ("Nama Lengkap");
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
    try {            
            Connection c=koneksiDB.getConnection();
            Statement s= c.createStatement();
            String sql="Select * from login_data2";
            ResultSet r=s.executeQuery(sql);
            while (r.next()) {
                Object[] o=new Object[5];
                o[0]=r.getString("id");
                o[1]=r.getString("username");
                o[2]=r.getString("password");      
                o[3]=r.getString("level_user");
                o[4]=r.getString("nama_pegawai");
                model.addRow(o);
            }
            for (int i=0; i<model.getColumnCount(); i++) {
                TableColumn column = table.getColumnModel().getColumn(i);
                if (i==0) column.setPreferredWidth(70);
                if (i==1) column.setPreferredWidth(100);
                if (i==2) column.setPreferredWidth(100);
                if (i==3) column.setPreferredWidth(90);
                if (i==4) column.setPreferredWidth(100);
            }
            r.close();
            s.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
        }
    }
 private void clear() {
        //clear data di text field
        username.setText(null);
        kodepegawai.setText(null);
        kodepegawai.setEditable(false);
        password.setText(null);
        JLevel_User.setSelectedItem("--PILIH--");
        ket.setText(null);
        del.setEnabled(false);
        simpan.setEnabled(true);
        ShowData();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        kodepegawai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        PASSWORD = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JLevel_User = new javax.swing.JComboBox<>();
        ket = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        update = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        del = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setClosable(true);
        setTitle("DATA LOGIN USER");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_47_2136349.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(241, 242, 246));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(214, 48, 49));
        jLabel7.setText("SEARCH");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        jPanel3.setBackground(new java.awt.Color(241, 242, 246));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pegawai", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 24), new java.awt.Color(214, 48, 49))); // NOI18N

        kodepegawai.setPreferredSize(new java.awt.Dimension(6, 22));

        jLabel6.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel6.setText("KODE PEGAWAI");

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel2.setText("USERNAME");

        PASSWORD.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        PASSWORD.setText("PASSWORD");

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel4.setText("LEVEL USER");

        JLevel_User.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH--", "Admin", "Operator" }));

        jLabel5.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel5.setText("NAMA PEGAWAI");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(PASSWORD)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ket)
                    .addComponent(kodepegawai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLevel_User, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kodepegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLevel_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 260, 240));

        search.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 220, 30));

        jPanel2.setBackground(new java.awt.Color(241, 242, 246));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Table Pegawai", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 24), new java.awt.Color(214, 48, 49))); // NOI18N

        table.setBackground(new java.awt.Color(241, 242, 246));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        table.setSelectionForeground(new java.awt.Color(46, 204, 113));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 420, 420));

        jPanel4.setBackground(new java.awt.Color(241, 242, 246));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tombol Operasi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 22), new java.awt.Color(214, 48, 49))); // NOI18N

        update.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        update.setText("UPDATE");
        update.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        update.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        simpan.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        simpan.setText("SIMPAN");
        simpan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        del.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        del.setText("DELETE");
        del.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        del.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        del.setPreferredSize(new java.awt.Dimension(67, 31));
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton1.setText("CLEAR");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(del, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(del, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 370, 90));

        jPanel5.setBackground(new java.awt.Color(241, 242, 246));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 14), new java.awt.Color(214, 48, 49))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_87_111095.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 93, -1, 130));

        jButton2.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jButton2.setText("ATTACH");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 90, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // fungsi untuk search data pegawai
        model=new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Level User");
        model.addColumn("Nama Lengkap");
        
        table.setModel(model);
        try{
            Connection c=koneksiDB.getConnection();
            Statement s= c.createStatement();
            ResultSet r = s.executeQuery("select * from login_data2 where username like '%" + search.getText()+ "%'");
            while (r.next()) {
                Object[] o=new Object[6];
                o[0]=r.getString("id");
                o[1]=r.getString("username");
                o[2]=r.getString("password");
                o[3]=r.getString("level_user");
                o[4]=r.getString("nama_pegawai");
                model.addRow(o);
            }
            for (int i=0; i<model.getColumnCount(); i++) {
                TableColumn column = table.getColumnModel().getColumn(i);
                if (i==0) column.setPreferredWidth(100);
                if (i==1) column.setPreferredWidth(100);
                if (i==2) column.setPreferredWidth(200);
                if (i==3) column.setPreferredWidth(90);
                if (i==4) column.setPreferredWidth(100);
                if (i==5) column.setPreferredWidth(100);
            }
            s.close();
            r.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_searchKeyReleased

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        //perintah untuk melakukan simpan
        ids   = kodepegawai.getText();
        usm   = username.getText();
        pas   = password.getText();
        lvu   = JLevel_User.getSelectedItem();
        keter = ket.getText();
        
        if (username.getText().equals("")) { 
            JOptionPane.showMessageDialog(this, "Username masih kosong");
        } else if (password.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Password masih kosong");
        } else if (JLevel_User.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Level user masih kosong");
        }
        else{
            try{            
                Connection c=koneksiDB.getConnection();
                PreparedStatement s= c.prepareStatement("insert into login_data2(id, username, password, level_user, nama_pegawai, foto_pegawai) values(?,?,?,?,?,?)");
//                String sql="INSERT INTO login_data2 (id, username, password, level_user, nama_pegawai)value"
//                        + "('"+ ids +"','"+ usm +"','"+ pas +"','"+ lvu +"','"+ keter +"')";
                s.setString(1, ids);
                s.setString(2, usm);
                s.setString(3, pas);
                s.setObject(4, lvu);
                s.setString(5, keter);
                s.setBytes(6, personimage);
                s.executeUpdate();
                clear();
                ShowData();
                AutoKodePegawai();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_87_111095.png")));
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        // fungsi untuk delete data yang ada di tabel
        if(username.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane,"Data Belum Lengkap","Perhatian",
                JOptionPane.WARNING_MESSAGE);
        }
        else{
            int i=table.getSelectedRow();
            if(i==-1)
            {
                return;
            }
            try {
                Connection c=koneksiDB.getConnection();
                Statement st=(Statement)c.createStatement();
                String sql = "DELETE From login_data2 where username = '" + username.getText() + "'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane,"Data Berhasil Dihapus");
                clear();
                st.close();
                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_87_111095.png")));
            }catch(SQLException e){
                JOptionPane.showMessageDialog(rootPane,e);
            }finally
            {
                ShowData();
                AutoKodePegawai();
            }
        }
    }//GEN-LAST:event_delActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        //perintah untuk update
        usm   = username.getText();
        pas   = password.getText();
        lvu   = JLevel_User.getSelectedItem();
        keter = ket.getText();
        if(username.getText().equals("")||password.getText().equals("")||ket.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane,"Data Belum Lengkap","Perhatian",JOptionPane.WARNING_MESSAGE);
        }
        else{
            int i=table.getSelectedRow();
            if(i==-1)
            {
                return;
            }
            try {
                Connection c=koneksiDB.getConnection();
                PreparedStatement st= c.prepareStatement("update login_data2 set username =?, password=?, level_user=?, nama_pegawai=?, foto_pegawai=? where id = '"+kodepegawai.getText()+"'");
//                String sql ="update login_data2 set username = '" + username.getText() +
//                "',password = '" + password.getText()+
//                "',level_user = '" + JLevel_User.getSelectedItem() +
//                "',nama_pegawai = '" + ket.getText() +
//                "',foto_pegawai = '" + personimage + "' where id = '" + kodepegawai.getText() + "'";
                st.setString(1, usm);
                st.setString(2, pas);
                st.setObject(3, lvu);
                st.setString(4, keter);
                st.setBytes(5, personimage);
                st.executeUpdate();
                JOptionPane.showMessageDialog(rootPane,"Data Berhasil Diubah");
                clear();
                st.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(rootPane,e);
            }finally{
                ShowData();
                AutoKodePegawai();
            }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        //perintah untuk select table

        int slct = table.getSelectedRow();
        if (slct==-1) {
            return;
        }
        String id=(String) model.getValueAt(slct, 0);
        kodepegawai.setText(id);
        String usm=(String) model.getValueAt(slct, 1);
        username.setText(usm);
        String pwd=(String) model.getValueAt(slct, 2);
        password.setText(pwd);
        String lvu=(String) model.getValueAt(slct, 3);
        JLevel_User.setSelectedItem(lvu);
        String nama=(String) model.getValueAt(slct, 4);
        ket.setText(nama);
                    try {
        Connection con = koneksiDB.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from login_data2 where id = '"+kodepegawai.getText()+"'");
            if(rs.next()){
                
                byte[] img = rs.getBytes("foto_pegawai");
                //Resize The ImageIcon
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                jLabel3.setIcon(newImage);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 101!");
        } catch (Exception f) {
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_87_111095.png")));
        }
        del.setEnabled(true);
        simpan.setEnabled(false);
        update.setEnabled(true);
    }//GEN-LAST:event_tableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //attach foto ke database
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage()
                .getScaledInstance(jLabel3.getWidth(),jLabel3.getHeight(),Image.SCALE_SMOOTH));
        jLabel3.setIcon(imageIcon);
        try {
            File image = new File (filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum=fis.read(buf))!=-1;) {
                bos.write(buf,0,readNum);
        }
            personimage = bos.toByteArray();
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, E);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                username.setText(null);
        kodepegawai.setEditable(false);
        password.setText(null);
        JLevel_User.setSelectedItem("--PILIH--");
        ket.setText(null);
        del.setEnabled(false);
        update.setEnabled(false);
        simpan.setEnabled(true);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_87_111095.png")));
        ShowData();
        AutoKodePegawai();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JLevel_User;
    private javax.swing.JLabel PASSWORD;
    private javax.swing.JButton del;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ket;
    private javax.swing.JTextField kodepegawai;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField search;
    private javax.swing.JButton simpan;
    private javax.swing.JTable table;
    private javax.swing.JButton update;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}

package aplikasi;

import com.util.FormUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.koneksiDB;


public class administratorBaru extends javax.swing.JInternalFrame {
    private DefaultTableModel model;
    private Connection con;
    private Statement st;
    private ResultSet tampil;
    private String sql=""; 
    private String usm="", pas="", lvu="", keter="", ids="";
    
  
    public administratorBaru() {
        initComponents();
        KoneksiDB();
        ShowData();
        FormUtil.centerWindow(this);
        clear();
        AutoKodePegawai();
        simpan.setEnabled(true);
        del.setEnabled(false);
        update.setEnabled(false);
    }

    private void KoneksiDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/axia_parkir", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
        }
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
  if (i==0) column.setPreferredWidth(30);
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
        JLevel_User.setSelectedItem(null);
        ket.setText(null);
        del.setEnabled(false);
//        jButton3.setEnabled(false);
        simpan.setEnabled(true);
//        AutoNumber();
        ShowData();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        JLevel_User = new javax.swing.JComboBox<>();
        close = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ket = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        del = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        kodepegawai = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        PASSWORD = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 10)); // NOI18N
        jLabel4.setText("LEVEL USER");

        JLevel_User.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Operator" }));
        JLevel_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JLevel_UserActionPerformed(evt);
            }
        });

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/resources/Exit.png"))); // NOI18N
        close.setText("CLOSE");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 10)); // NOI18N
        jLabel5.setText("NAMA PEGAWAI");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 10)); // NOI18N
        jLabel7.setText("SEARCH");

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/resources/simpan.png"))); // NOI18N
        simpan.setText("SIMPAN");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        simpan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                simpanKeyTyped(evt);
            }
        });

        del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/resources/Delete-32.png"))); // NOI18N
        del.setText("DELETE");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });

        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/resources/Modify.png"))); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 10)); // NOI18N
        jLabel6.setText("KODE PEGAWAI");

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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        kodepegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodepegawaiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 10)); // NOI18N
        jLabel2.setText("USERNAME");

        PASSWORD.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 10)); // NOI18N
        PASSWORD.setText("PASSWORD");

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel1.setText("DATA PEGAWAI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(162, 162, 162)
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
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kodepegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLevel_User, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ket, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7))
                            .addComponent(jLabel2)
                            .addComponent(PASSWORD))
                        .addGap(17, 17, 17)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(simpan)
                        .addGap(18, 18, 18)
                        .addComponent(del)
                        .addGap(15, 15, 15)
                        .addComponent(update)
                        .addGap(18, 18, 18)
                        .addComponent(close)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kodepegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PASSWORD))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLevel_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(del, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kodepegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodepegawaiActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_kodepegawaiActionPerformed

    private void JLevel_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JLevel_UserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JLevel_UserActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

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

        ids=String.valueOf(kodepegawai.getText());
        usm=String.valueOf(username.getText());
        pas=String.valueOf(password.getText());
        lvu=String.valueOf(JLevel_User.getSelectedItem());
        keter=String.valueOf(ket.getText());

        try{
            sql="INSERT INTO login_data2 (id, username, password, level_user, nama_pegawai)value"
            + "('"+ ids +"','"+ usm +"','"+ pas +"','"+ lvu +"','"+ keter +"')";
            st=con.createStatement();
            st.execute(sql);
            clear();
            ShowData();
            AutoKodePegawai();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR \n Data Gagal Disimpan"+e.getMessage());
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void simpanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_simpanKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_simpanKeyTyped

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
        // TODO add your handling code here:
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
                Statement st=(Statement)c.createStatement();
                String sql ="update login_data2 set username = '" + username.getText() +
                "',password = '" + password.getText()+
                "',level_user = '" + JLevel_User.getSelectedItem() +
                "',nama_pegawai = '" + ket.getText() +
                "' where id = '" + kodepegawai.getText() + "'";
                st.executeUpdate(sql);
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
        del.setEnabled(true);
        simpan.setEnabled(false);
        update.setEnabled(true);

    }//GEN-LAST:event_tableMouseClicked

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        //close window
        this.dispose();
    }//GEN-LAST:event_closeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JLevel_User;
    private javax.swing.JLabel PASSWORD;
    private javax.swing.JButton close;
    private javax.swing.JButton del;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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

package aplikasi;

//import untuk source code aplikasi
import javax.swing.JOptionPane;
import java.sql.Statement;
import koneksi.koneksiDB;
import java.sql.ResultSet;
import java.awt.Toolkit;
import java.awt.HeadlessException;
import java.sql.SQLException;

public class frameLogin extends javax.swing.JFrame {
    
    public frameLogin() {
        initComponents();
        setIcon();
        Username.setEditable(false);
        Password.setEditable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Login = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        JLevelUser = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(101, 108, 164));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Login.setBackground(new java.awt.Color(255, 255, 255));
        Login.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        Login.setText("LOGIN");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        Login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LoginKeyPressed(evt);
            }
        });
        jPanel1.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 290, 65));

        Exit.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_ic_close_48px_352270.png"))); // NOI18N
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jPanel1.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 30, 30));

        jLabel1.setBackground(new java.awt.Color(190, 126, 50));
        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel1.setText("USER LOGIN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 170, -1));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 50, 20));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 14))); // NOI18N

        JLevelUser.setFont(new java.awt.Font("Agency FB", 0, 17)); // NOI18N
        JLevelUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIH --", "Admin", "Operator" }));
        JLevelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JLevelUserActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 17)); // NOI18N
        jLabel4.setText("USER");

        Username.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        Username.setDisabledTextColor(new java.awt.Color(41, 128, 185));
        Username.setSelectedTextColor(new java.awt.Color(41, 128, 185));
        Username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UsernameKeyPressed(evt);
            }
        });

        Password.setFont(new java.awt.Font("Agency FB", 0, 16)); // NOI18N
        Password.setDisabledTextColor(new java.awt.Color(41, 128, 185));
        Password.setSelectedTextColor(new java.awt.Color(41, 128, 185));
        Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Agency FB", 0, 17)); // NOI18N
        jLabel3.setText("PASSWORD");

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 17)); // NOI18N
        jLabel2.setText("USERNAME");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLevelUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JLevelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 290, 110));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/userlogin2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 34, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(300, 300, 300)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(300, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(219, 219, 219)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(220, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(600, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     private void setIcon() {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/gambar/mbl.png")));
    }
    public void enterkeypress() {
        String username = Username.getText();
        String password = Password.getText();
        String leveluser = JLevelUser.getSelectedItem().toString();
        
        try
        {
        Statement statement = (Statement)koneksiDB.getConnection().createStatement();//statement untuk konek database
        ResultSet result  = statement.executeQuery("select * from login_data2 where "
                + "" + "username='" + username + "'");//verifikasi data login berdasarkan username yang ada didatabase
        
            if (result.next()) {
                String namalengkap = result.getString("nama_pegawai");
                if(leveluser.equals(result.getString("level_user"))){
                    if(password.equals(result.getString("Password"))){
                        if(leveluser.equals("Admin")){
                            this.setVisible(false);
                            new menuAdmin().setVisible(true);
                            this.dispose();
                        }// hak akses user berdasarkan level user
                        else {
                            this.setVisible(false);
                            new menu().setVisible(true);
                            this.dispose();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane,"Password Salah");
                        Password.setText("");
                        Username.requestFocus();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(rootPane,"User Tidak Sesuai");
                    JLevelUser.setSelectedItem("");
                    Username.setText("");
                    Password.setText("");
                    Username.requestFocus();
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane,"User Tidak Ditemukan");
                Username.setText("");
                Password.setText("");
                Username.requestFocus();
            }
        }
        catch (HeadlessException | SQLException e) {
//            JOptionPane.showMessageDialog(rootPane,"Error 101!");
        e.getStackTrace();
        }
    }
    public void enterkeypress2() {
        String username = Username.getText();
        String password = Password.getText();
        String kodepegawai= null, namapegawai = null;
        String leveluser = JLevelUser.getSelectedItem().toString(); 
        try {
            String sql = "SELECT * FROM login_data2 WHERE username = '" + username + "' AND password = '" + password + "'";
            Statement st = koneksiDB.getConnection().createStatement();
            ResultSet rsLogin = st.executeQuery(sql);

            while (rsLogin.next()) {
                kodepegawai = rsLogin.getString("id");
                namapegawai = rsLogin.getString("nama_pegawai");
            }
            rsLogin.last(); //mengecek jumlah baris pada hasil query
            if (rsLogin.getRow()==1){
                userakses.setU_kodePegawai(kodepegawai);
                userakses.setU_username(username);
                userakses.setU_password(password);
                userakses.setU_levelUser(leveluser);
                userakses.setU_nama(namapegawai);
//                userakses.setU_fotoUser(fotopegawai);
                    if(leveluser.equals(rsLogin.getString("level_user"))){
                        if(leveluser.equals("Admin")){
                            this.setVisible(false);
                            new menuAdmin().setVisible(true);
                            this.dispose();
                            }// hak akses user berdasarkan level user
                        else {
                            this.setVisible(false);
                            new menu().setVisible(true);
                            this.dispose(); }
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane,"User Tidak Sesuai");
                        JLevelUser.setSelectedItem("");
                        Username.setText("");
                        Password.setText("");
                        Username.requestFocus();
                    }
            } else {
                JOptionPane.showMessageDialog(null, "Maaf, Username / Password salah!");
                Username.setText("");
                Password.setText("");
                Username.requestFocus();
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 101, Please Read Manual Book", "Warning!", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        try {   
            enterkeypress2();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error 101, Please Read Manual Book", "Warning!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // source menu exit
        if (JOptionPane.showConfirmDialog(null,"Do you want to exit ?", 
                "Warning!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        System.exit(0);
        }
    }//GEN-LAST:event_ExitActionPerformed
  
    private void LoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoginKeyPressed
        //dispose setelah login di tekan
        this.dispose();
    }//GEN-LAST:event_LoginKeyPressed

    private void UsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UsernameKeyPressed
        // TODO add your handling code here:
        try {
            if (evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) {
                enterkeypress2();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error 101, Please Read Manual Book", "Warning!", JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_UsernameKeyPressed

    private void PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyPressed
        // TODO add your handling code here:
        try {
            if (evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) {
                enterkeypress2();
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error 101, Please Read Manual Book", "Warning!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_PasswordKeyPressed

    private void JLevelUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JLevelUserActionPerformed
        // TODO add your handling code here:
        int a = JLevelUser.getSelectedIndex();
        switch (a) {
            case 1:
                Username.requestFocus();
                Username.setEditable(true);
                Password.setEditable(true);
                break;
            case 2:
                Username.requestFocus();
                Username.setEditable(true);
                Password.setEditable(true);
                break;
            case 0:
                Username.setEditable(false);
                Password.setEditable(false);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_JLevelUserActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameLogin().setVisible(true);
            }
        });
    }    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    public static javax.swing.JComboBox<String> JLevelUser;
    private javax.swing.JButton Login;
    public static javax.swing.JPasswordField Password;
    public static javax.swing.JTextField Username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

}
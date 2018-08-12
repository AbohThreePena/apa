package com.controller;

import aplikasi.frameLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import koneksi.koneksiDB;
import aplikasi.menuAdmin;
import aplikasi.menu;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import aplikasi.userakses;

public class loginCon {

    frameLogin login = null;
    
    public loginCon (frameLogin login) {
        this.login = login;
    }
    
    public void enterkeypress2() {
        String username = login.txtUsername.getText();
        String password = login.txtPassword.getText();
        String kodepegawai= null, namapegawai = null;
        String leveluser = login.jComboUser.getSelectedItem().toString(); 
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
//                            this.setVisible(false);
                            new menuAdmin().setVisible(true);
                            new frameLogin().setVisible(false);
//                            this.dispose();
                            }// hak akses user berdasarkan level user
                        else {
//                            this.setVisible(false);
                            new menu().setVisible(true);
                            new frameLogin().setVisible(false);
//                            this.dispose(); 
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"User Tidak Sesuai");
                        login.jComboUser.setSelectedItem("");
                        login.txtUsername.setText("");
                        login.txtPassword.setText("");
                        login.txtUsername.requestFocus();
                        new frameLogin().setVisible(true);
                    }
            } else {
                JOptionPane.showMessageDialog(null, "Maaf, Username / Password salah!");
                login.txtUsername.setText("");
                login.txtPassword.setText("");
                login.txtUsername.requestFocus();
                new frameLogin().setVisible(true);
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 101, Please Read Manual Book", "Warning!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void comboAksi() {
        int a = login.jComboUser.getSelectedIndex();
        switch (a) {
            case 1:
                login.txtUsername.requestFocus();
                login.txtUsername.setEditable(true);
                login.txtPassword.setEditable(true);
                break;
            case 2:
                login.txtUsername.requestFocus();
                login.txtUsername.setEditable(true);
                login.txtPassword.setEditable(true);
                break;
            case 0:
                login.txtUsername.setEditable(false);
                login.txtPassword.setEditable(false);
                break;
            default:
                break;
        }
    }
}
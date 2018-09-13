package com.controller;
import aplikasi.aplikasiSetting;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import koneksi.koneksiDB;

public class settingCon {
    
    aplikasiSetting setting = null;
    private Integer harken=0, tiket=0, maks=0;
    private String jeken = "";
    public String harken2, tiket2, maks2 = "";
    public int slct = 0;
    NumberFormat numFormat = NumberFormat.getInstance();
    NumberFormatter numFormatter;
    
    public settingCon (aplikasiSetting setting) {
        this.setting = setting;
    }
    
    public void ShowData(){
        setting.model = new DefaultTableModel();
        setting.jTable1.setModel(setting.model);
        setting.model.addColumn ("NO");
        setting.model.addColumn ("JEN. KENDARAAN");
        setting.model.addColumn ("HARGA KENDARAAN");
        setting.model.addColumn ("TIKET HILANG");
        setting.model.addColumn ("HARGA MAX KEND.");
        setting.model.getDataVector().removeAllElements();
        setting.model.fireTableDataChanged();
    try {
            Connection c=koneksiDB.getConnection();
            Statement s= c.createStatement();
            String sql="Select * from harga_kendaraan";
            ResultSet r=s.executeQuery(sql);
            while (r.next()) 
            {
                Object[] o=new Object[6];
                for (int a = 0; a <= setting.model.getRowCount(); a++) {
                    o[0]= a+1;
                }
                o[1]=r.getString("jenis_kendaraan");
                o[2]=r.getInt("harga_kendaraan");
                o[3]=r.getInt("tiket_hilang");
                o[4]=r.getInt("harga_maks_kend");
                setting.model.addRow(o);
            }   
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
    }
}
        public void clear() {
        setting.textJenisKendaraan.setText("");
        setting.textHargaKendaraan.setText("");
        setting.textDendaTiket.setText("");
        setting.textHargaMaksimum.setText("");
    }
        public void updateButton() {
            //fungsi untuk update table ke database
            tiket2 = String.valueOf(setting.textDendaTiket.getText());
            maks2 = String.valueOf(setting.textHargaMaksimum.getText());
            harken2 = String.valueOf(setting.textHargaKendaraan.getText());
            String hk = harken2.replaceAll("[.]", "");
            String tkt = tiket2.replaceAll("[.]", "");
            String mh = maks2.replaceAll("[.]", "");
            
            int slct = setting.jTable1.getSelectedRow();
//            String nomor = (String) setting.model.getValueAt(slct, 0);

            if(setting.textJenisKendaraan.getText().equals("")|| setting.textHargaKendaraan.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Data Belum Lengkap","Perhatian",JOptionPane.WARNING_MESSAGE);
            }
            else{
                int i=setting.jTable1.getSelectedRow();
                if(i==-1)
                {
                    return;
                }
                try {
                    Connection c=koneksiDB.getConnection();
                    Statement st=(Statement)c.createStatement();
                    String sql ="update harga_kendaraan set "
                            + "jenis_kendaraan = '" + setting.textJenisKendaraan.getText() 
                            +"', harga_kendaraan = '" +hk+"', tiket_hilang ='"+tkt+"', "
                            + "harga_maks_kend ='"+mh+"' where jenis_kendaraan ='"+setting.textJenisKendaraan.getText()+"'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null,"Data Berhasil Diubah");
                    clear();
                    st.close();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,e);
                }finally{
                    ShowData();
                    setting.jButton2.setEnabled(false);
                    setting.jButton3.setEnabled(false);
                    setting.jButton1.setEnabled(true);
                }
            }
        }
        
        public void selectTable()  {
            //fungsi untuk select table dan menampilkan di text field
                slct = setting.jTable1.getSelectedRow();
                if (slct==-1) {
//                    Connection c = koneksiDB.getConnection();
//                    Statement s = c.createStatement();
//                    String sql = "Select * from parkir_keluar where jenis_kendaraan = '"+setting.textJenisKendaraan+"'";
//                    ResultSet rs = s.executeQuery(sql);
                    return;
//                    while(rs.next()) {
//                        rs.getString("jenis_kendaraan");
//                    }
                }

                jeken = (String) setting.model.getValueAt(slct, 1);
                setting.textJenisKendaraan.setText(jeken);
                
                harken = (Integer) setting.model.getValueAt(slct, 2);
                NumberFormat nf = NumberFormat.getInstance();
                setting.textHargaKendaraan.setText(nf.format(harken));

                tiket = (Integer) setting.model.getValueAt(slct, 3);
                setting.textDendaTiket.setText(nf.format(tiket));

                maks = (Integer) setting.model.getValueAt(slct, 4);
                setting.textHargaMaksimum.setText(nf.format(maks));                

                setting.jButton2.setEnabled(true);
                setting.jButton3.setEnabled(true);
                setting.jButton1.setEnabled(false);        
        }
        public void deleteButton() {
        // perintah untuk delete data di database
        if(setting.textJenisKendaraan.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Belum Lengkap","Perhatian",
                JOptionPane.WARNING_MESSAGE);
        }else{
            int i=setting.jTable1.getSelectedRow();
            if(i==-1){
                return;
            }
            try {
                Connection c=koneksiDB.getConnection();
                Statement st=(Statement)c.createStatement();
                String sql = "DELETE From harga_kendaraan where jenis_kendaraan = "
                        + "'" + setting.textJenisKendaraan.getText() + "'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
                clear();
                st.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Error 101");
            }finally{
                ShowData();
                setting.jButton2.setEnabled(false);
                setting.jButton3.setEnabled(false);
                setting.jButton1.setEnabled(true);
                }
            }
        }
        
        public void addButton() {
        // perintah untuk submit ke database 
        if (setting.textJenisKendaraan.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Mohon Isi Jenis Kendaraan!");
        } else if (setting.textHargaKendaraan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Mohon Isi Harga Kendaraan!");
        } else if (setting.textDendaTiket.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Mohon Isi Denda Tiket Kendaraan!"); 
        } else if (setting.textHargaMaksimum.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Mohon Isi Harga Maksimum Kendaraan!");
        } else {
                try{
                    jeken  = setting.textJenisKendaraan.getText().toUpperCase();
                    harken = Integer.valueOf(setting.textHargaKendaraan.getText());
                    tiket = Integer.valueOf(setting.textDendaTiket.getText());
                    maks = Integer.valueOf(setting.textHargaMaksimum.getText());
                    Connection c=koneksiDB.getConnection();
                    Statement s= c.createStatement();
                    String sql="INSERT INTO harga_kendaraan (jenis_kendaraan, harga_kendaraan, "
                            + "tiket_hilang, harga_maks_kend) value"
                    + "('"+ jeken +"','"+ harken +"','"+ tiket +"','"+ maks +"')";
                    s.execute(sql);
                    clear();
                    ShowData();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR \n Data Gagal Disimpan");
                } finally {
                    setting.jButton2.setEnabled(false);
                    setting.jButton3.setEnabled(false);
                }
            }
        }
        
        public void clickForm() {
            setting.textJenisKendaraan.setText(null);
            setting.textHargaKendaraan.setText(null);
            setting.textDendaTiket.setText(null);
            setting.textHargaMaksimum.setText(null);
            setting.jButton2.setEnabled(false);
            setting.jButton3.setEnabled(false);
            setting.jButton1.setEnabled(true);
        }
        
        public void setCurrencyNow()
        {
        //  set banyaknya angka akhir bilangan
        numFormat.setMaximumFractionDigits(0);
         //        String limit = textHargaKendaraan.getText();
//        char c = evt.getKeyChar();
//        if (!(Character.isDigit(c) || (c==KeyEvent.VK_BACKSPACE) || c==KeyEvent.VK_DELETE)) {
//            evt.consume(); 
//        } else if (limit.length() == 10 || c==KeyEvent.VK_BACKSPACE || c==KeyEvent.VK_DELETE) {
//            evt.consume();
//        }
        //  Deklarasikan NumberFormatter
        numFormatter = new NumberFormatter(numFormat);
        numFormatter.setAllowsInvalid(false);
        setting.textHargaKendaraan = new JFormattedTextField(numFormatter);
        }
}
package aplikasi;
import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfReader;
import com.util.FormUtil;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.koneksiDB;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.components.map.Item;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import java.text.*;
import java.awt.print.*;


public class laporan extends javax.swing.JInternalFrame {

    public Connection conn;
    private DefaultTableModel model;
    private String sql="";
    public laporan(){
        koneksi();
        initComponents();
        FormUtil.centerWindow(this);
    }
    public void koneksi()   {
            // TODO add your handling code here:
            try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/axia_parkir", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
        }
    }
    public void date () {
        SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dformat.format(jDateChooser1.getDate());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jButton4.setText("SUBMIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nomor Kendaraan", "Nomor Karcis", "Jenis Kendaraan", "Jam Masuk", "Jam Keluar", "Lama Parkir", "Harga Kendaraan", "Total Harga"
            }
        ));
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.setFocusable(false);
        table.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                tableMouseWheelMoved(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(100);
            table.getColumnModel().getColumn(1).setMinWidth(100);
            table.getColumnModel().getColumn(2).setMinWidth(100);
            table.getColumnModel().getColumn(3).setMinWidth(100);
            table.getColumnModel().getColumn(4).setMinWidth(100);
            table.getColumnModel().getColumn(5).setMinWidth(100);
            table.getColumnModel().getColumn(6).setMinWidth(100);
            table.getColumnModel().getColumn(7).setMinWidth(100);
        }

        jScrollPane1.setViewportView(jScrollPane2);

        jLabel1.setText("DARI TANGGAL");

        jLabel2.setText("SAMPAI TANGGAL");

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("PRINT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(32, 32, 32)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("HARIAN", jPanel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //fungsi untuk memangigl tanggal.
        model = new DefaultTableModel();
        table.setModel(model);
        model.addColumn ("Nomor Kendaraan");
        model.addColumn ("Nomor Karcis");
        model.addColumn ("Jenis Kendaraan");
        model.addColumn ("Jam Masuk");
        model.addColumn ("Jam Keluar");
        model.addColumn ("Lama Parkir");
        model.addColumn ("Harga Kendaraan");
        model.addColumn ("Total Harga");
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c=koneksiDB.getConnection();
            Statement s= c.createStatement();
            SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dformat.format(jDateChooser1.getDate());
            String date2 = dformat.format(jDateChooser2.getDate());
            String sql  = "SELECT * FROM parkir_keluar WHERE jam_keluar >= '"+date+" 00:00:00' AND jam_keluar < '"+date2+" 23:59:59'";
            ResultSet r=s.executeQuery(sql);
            while (r.next()) {
                Object[] o=new Object[8];
                o[0]=r.getString("nomor_kendaraan");
                o[1]=r.getString("nomor_karcis");
                o[2]=r.getString("jenis_kendaraan");
                o[3]=r.getString("jam_masuk");
                o[4]=r.getString("jam_keluar");
                o[5]=r.getString("lama_parkir");
                o[6]=r.getString("harga_kendaraan");
                o[7]=r.getString("total_bayar");
                model.addRow(o);
            }
            for (int i=0; i<model.getColumnCount(); i++) {
                TableColumn column = table.getColumnModel().getColumn(i);
                if (i==0) column.setPreferredWidth(100);
                if (i==1) column.setPreferredWidth(100);
                if (i==2) column.setPreferredWidth(90);
                if (i==3) column.setPreferredWidth(100);
                if (i==4) column.setPreferredWidth(100);
                if (i==5) column.setPreferredWidth(100);
                if (i==6) column.setPreferredWidth(100);
                if (i==7) column.setPreferredWidth(100);
            }
            r.close();
            s.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tableMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_tableMouseWheelMoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tableMouseWheelMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//print
//    MessageFormat header = new MessageFormat("Report Print");
//    MessageFormat footer = new MessageFormat("Page{0,number,integer}");
//    
//    try {
//        table.print(JTable.PrintMode.NORMAL, header, footer);
//    } catch(Exception e) {
//        System.out.println("Gagal");
//    }
        
//             cetak ke jasper report
        SimpleDateFormat dformat2 = new SimpleDateFormat("yyyy-MM-dd");
        String date = dformat2.format(jDateChooser1.getDate());
        String date2 = dformat2.format(jDateChooser2.getDate());
//        String date2 = "2018-04-10 14:26:11";
        try{
            String jrxmlFile = "src/laporantiket/laporan.jrxml";
            Connection c = koneksiDB.getConnection();
            HashMap param = new HashMap();
            param.put("jamkeluar", Date.valueOf(date));
            param.put("jamkeluar2", Date.valueOf(date2));
            JasperReport JRpt =  JasperCompileManager.compileReport(jrxmlFile);
            JasperPrint JPrint = JasperFillManager.fillReport(JRpt, param, c);
            JasperViewer.viewReport(JPrint, true);
        }
        catch(JRException e){
            JOptionPane.showMessageDialog(rootPane, e); } catch (SQLException ex) {
            Logger.getLogger(parkirmasuk.class.getName()).log(Level.SEVERE, null, ex); }

//try {
//DefaultTableModel model = new DefaultTableModel(); // TableModel implementation here
//JTable table = new JTable(model);
//HashMap params = new HashMap();
//JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource((Collection<?>) table.getModel());
//JasperPrint print = JasperFillManager.fillReport("src/laporantiket/laporan.jrxml", params, dataSource);
//JasperViewer.viewReport(print, true); // true == Exit on Close
//} catch (JRException ex) {
//            Logger.getLogger(laporan.class.getName()).log(Level.SEVERE, null, ex);
//}

//try {
//    PdfReader report = new PdfReader("Report.pdf");
//    PdfReader report2 = new PdfReader("Report1.pdf");
//    PdfCopyFields copy = new PdfCopyFields(new FileOutputStream("Joined Report.pdf"));
//    copy.addDocument(report);
//    copy.addDocument(report2);
//    copy.close();
//    JOptionPane.showMessageDialog(null,"Copy Saved");
//} catch (Exception e) {
//    
//}

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}

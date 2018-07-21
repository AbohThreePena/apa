package aplikasi;

import com.util.FormUtil;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.koneksiDB;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.JScrollPane;

public class laporan extends javax.swing.JInternalFrame {
    
    public Connection conn;
    private DefaultTableModel model;
    private String sql="";
    private JScrollPane scroll;
    private ResultSet r;

    public laporan(){
        initComponents();
        FormUtil.centerWindow(this);
        jButton2.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBorder(null);
        setTitle("LAPORAN ");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/if_document_text_information_103515.png"))); // NOI18N

        jPanel12.setBackground(new java.awt.Color(106, 137, 204));

        jButton4.setBackground(new java.awt.Color(220, 221, 225));
        jButton4.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jButton4.setText("SUBMIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel1.setText("DARI TANGGAL");

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel2.setText("SAMPAI TANGGAL");

        jButton1.setBackground(new java.awt.Color(220, 221, 225));
        jButton1.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(220, 221, 225));
        jButton2.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jButton2.setText("PRINT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nomor Kendaraan", "Jenis Kendaraan", "Jam Masuk", "Jam Keluar", "Durasi", "Nomor Karcis", "Harga Kendaraan", "Total Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.setFocusable(false);
        table.setMinimumSize(new java.awt.Dimension(150, 64));
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(100);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setMinWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setMinWidth(70);
            table.getColumnModel().getColumn(2).setPreferredWidth(70);
            table.getColumnModel().getColumn(3).setMinWidth(70);
            table.getColumnModel().getColumn(3).setPreferredWidth(70);
            table.getColumnModel().getColumn(4).setMinWidth(70);
            table.getColumnModel().getColumn(4).setPreferredWidth(70);
            table.getColumnModel().getColumn(5).setMinWidth(100);
            table.getColumnModel().getColumn(5).setPreferredWidth(100);
            table.getColumnModel().getColumn(6).setMinWidth(100);
            table.getColumnModel().getColumn(6).setPreferredWidth(100);
            table.getColumnModel().getColumn(7).setMinWidth(100);
            table.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("DATA LAPORAN PARKIR", jPanel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //fungsi untuk memangigl tanggal.
        String dateInput = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        String dateInput2 = ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText();
        if (dateInput.equals("") || dateInput2.equals("")) {
            JOptionPane.showMessageDialog(null, "Mohon Mengisi Tanggal Yang Masih Kosong",
                    "Perhatian!!", JOptionPane.ERROR_MESSAGE);
        } else {
        model = new DefaultTableModel();
        table.setModel(model);
        model.addColumn ("Nomor Kendaraan");
        model.addColumn ("Nomor Karcis");
        model.addColumn ("Jenis Kendaraan");
        model.addColumn ("Jam Masuk");
        model.addColumn ("Jam Keluar");
        model.addColumn ("Durasi");
        model.addColumn ("Total Harga");
        model.getDataVector().removeAllElements();
        try {
            Connection c=koneksiDB.getConnection();
            Statement s = c.createStatement();
            SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dformat.format(jDateChooser1.getDate());
            String date2 = dformat.format(jDateChooser2.getDate());
            sql  = "SELECT * FROM parkir_keluar WHERE jam_keluar >= '"+date+" 00:00:00' AND "
                    + "jam_keluar < '"+date2+" 23:59:59'";
            r=s.executeQuery(sql);
            while (r.next()) {
                Object[] o=new Object[7];
                o[0]=r.getString("nomor_kendaraan");
                o[1]=r.getString("nomor_karcis");
                o[2]=r.getString("jenis_kendaraan");
                o[3]=r.getString("jam_masuk");
                o[4]=r.getString("jam_keluar");
                o[5]=r.getString("lama_parkir");
                o[6]=r.getString("total_bayar");
                model.addRow(o);
            }
            for (int i=0; i<model.getColumnCount(); i++) {
                TableColumn column = table.getColumnModel().getColumn(i);
                if (i==0) column.setPreferredWidth(100);
                if (i==1) column.setPreferredWidth(100);
                if (i==2) column.setPreferredWidth(90);
                if (i==3) column.setPreferredWidth(100);
                if (i==4) column.setPreferredWidth(100);
                if (i==5) column.setPreferredWidth(50);
                if (i==6) column.setPreferredWidth(100);
            }
            r.close();
            s.close();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error 101, Please Read Manual Book", 
                    "Warning!", JOptionPane.ERROR_MESSAGE);
        } finally {
            jButton2.setEnabled(true);
        } 
        }        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     //             cetak ke jasper report
        SimpleDateFormat dformat2 = new SimpleDateFormat("yyyy-MM-dd");
        String date = dformat2.format(jDateChooser1.getDate());
        String date2 = dformat2.format(jDateChooser2.getDate());
        try{
            String jrxmlFile = "C:\\Users\\Singgih\\Desktop\\Aplikasi Parkir Axia\\"
                    + "Aplikasi Parkir Axia\\src\\laporantiket\\laporan.jrxml";
            Connection c = koneksiDB.getConnection();
            HashMap param = new HashMap();
            param.put("jamkeluar", Date.valueOf(date));
            param.put("jamkeluar2", Date.valueOf(date2));

            JasperReport JRpt =  JasperCompileManager.compileReport(jrxmlFile);
            JasperPrint JPrint = JasperFillManager.fillReport(JRpt, param, c);
            JasperViewer.viewReport(JPrint, false);
        }
        catch(JRException e){
            JOptionPane.showMessageDialog(null, "Error 205"); } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error 205");
        } catch (Exception f) {
            JOptionPane.showMessageDialog(null, "Error 205");
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
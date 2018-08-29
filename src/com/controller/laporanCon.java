package com.controller;

import aplikasi.laporan;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;
import koneksi.koneksiDB;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class laporanCon {

    String date = "";
    String date2 = "";
    String dateInput = "";
    String dateInput2 = "";
    laporan lapor = null;
    public Connection conn;
    private DefaultTableModel model;
    private String sql = "";
    private ResultSet r = null;
    public TableColumn column = null;
    public TableRow rows = null;
    String[] headers = new String[] {"Nomor Polisi", "Nomor Karcis", "Jenis Kendaraan", 
        "Jam Masuk", "Jam Keluar", "Durasi", "Total Harga"};
    
    public laporanCon(laporan lapor) {
        this.lapor = lapor;
    }

    public void submit() {
        lapor.jButton2.setEnabled(false);
        dateInput = ((JTextField) lapor.jDateChooser1.getDateEditor().getUiComponent()).getText();
        dateInput2 = ((JTextField) lapor.jDateChooser2.getDateEditor().getUiComponent()).getText();
        java.util.Date a = lapor.jDateChooser1.getDate();
        java.util.Date b = lapor.jDateChooser2.getDate();
        if (a == null || b == null) {
            JOptionPane.showMessageDialog(null, "Mohon Mengisi Tanggal Yang Masih Kosong",
                    "Perhatian!!", JOptionPane.ERROR_MESSAGE);
        } else {
            long a2 = Math.abs(a.getTime());
            long b2 = Math.abs(b.getTime());
            if (a2 > b2) {
                JOptionPane.showMessageDialog(null, "Tanggal Awal Lebih Besar Dibanding Tanggal Akhir",
                        "Warning!", JOptionPane.ERROR_MESSAGE);
//                clear();
            } else {
//                }
//            else {
                model = new DefaultTableModel();
                lapor.table.setModel(model);
                model.addColumn("Plat Nomor");
                model.addColumn("Nomor Karcis");
                model.addColumn("Jenis Kendaraan");
                model.addColumn("Jam Masuk");
                model.addColumn("Jam Keluar");
                model.addColumn("Durasi");
                model.addColumn("Total Harga");
                model.getDataVector().removeAllElements();
                try {
                    Connection c = koneksiDB.getConnection();
                    Statement s = c.createStatement();
                    SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
                    date = dformat.format(lapor.jDateChooser1.getDate());
                    date2 = dformat.format(lapor.jDateChooser2.getDate());
                    sql = "SELECT * FROM parkir_keluar WHERE jam_keluar >= '" + date + " 00:00:00' AND "
                            + "jam_keluar < '" + date2 + " 23:59:59'";
                    r = s.executeQuery(sql);
                    if (!r.next()) {
                        JOptionPane.showMessageDialog(null, "Tidak Ada Data",
                                "Perhatian!!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        while (r.next()) {
                            int count = 0;
                            Object[] o = new Object[7];
                            o[0] = r.getString("nomor_kendaraan");
                            o[1] = r.getString("nomor_karcis");
                            o[2] = r.getString("jenis_kendaraan");
                            o[3] = r.getString("jam_masuk");
                            o[4] = r.getString("jam_keluar");
                            o[5] = r.getString("lama_parkir");
                            o[6] = r.getString("total_bayar");
                            model.addRow(o);
                            count++;
                            if (count < 1) {
                                lapor.jButton2.setEnabled(false);
                                lapor.jButton3.setEnabled(false);
                            } else {
                                lapor.jButton2.setEnabled(true);
                                lapor.jButton3.setEnabled(true);
                            }
                        }
                        for (int i = 0; i < model.getColumnCount(); i++) {
                            column = lapor.table.getColumnModel().getColumn(i);
                            if (i == 0) {
                                column.setPreferredWidth(100);
                            }
                            if (i == 1) {
                                column.setPreferredWidth(100);
                            }
                            if (i == 2) {
                                column.setPreferredWidth(90);
                            }
                            if (i == 3) {
                                column.setPreferredWidth(100);
                            }
                            if (i == 4) {
                                column.setPreferredWidth(100);
                            }
                            if (i == 5) {
                                column.setPreferredWidth(50);
                            }
                            if (i == 6) {
                                column.setPreferredWidth(100);
                            }
                        }
                    }
                    r.close();
                    s.close();
                    lapor.jDateChooser1.setEnabled(false);
                    lapor.jDateChooser2.setEnabled(false);
                    lapor.jButton1.setEnabled(true);
                    lapor.jButton4.setEnabled(false);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error 101, Please Read Manual Book",
                            "Warning!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void print() throws ParseException {
        SimpleDateFormat dformat2 = new SimpleDateFormat("yyyy-MM-dd");
        date = dformat2.format(lapor.jDateChooser1.getDate());
        date2 = dformat2.format(lapor.jDateChooser2.getDate());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dformat2.parse(date2));
        calendar.add(Calendar.DATE, 1);
        String date3 = dformat2.format(calendar.getTime());
        try {
            String jrxmlFile = "C:\\Users\\Singgih\\Desktop\\Aplikasi Parkir Axia\\"
                    + "Aplikasi Parkir Axia\\src\\laporantiket\\laporan.jrxml";
            Connection c = koneksiDB.getConnection();
            HashMap param = new HashMap();
            param.put("jamkeluar", Date.valueOf(date));
            param.put("jamkeluar2", Date.valueOf(date3));
            JasperReport JRpt = JasperCompileManager.compileReport(jrxmlFile);
            JasperPrint JPrint = JasperFillManager.fillReport(JRpt, param, c);
            JasperViewer.viewReport(JPrint, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Error 205");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 205");
        } catch (Exception f) {
            JOptionPane.showMessageDialog(null, "Error 205");
        }
    }

    public void clear() {
        lapor.jDateChooser1.setEnabled(true);
        lapor.jDateChooser2.setEnabled(true);
        lapor.jButton2.setEnabled(false);
        lapor.jDateChooser1.setCalendar(null);
        lapor.jDateChooser2.setCalendar(null);
        model.setRowCount(0);
        lapor.jButton1.setEnabled(false);
        lapor.jButton4.setEnabled(true);
        lapor.jButton3.setEnabled(false);
    }

    public void exportExcels() {
        String efp = "LaporanParkir.xls";
        try {
            FileInputStream fis = new FileInputStream(new File(efp));
            Workbook wb = WorkbookFactory.create(fis);
//            Sheet sheet = wb.getSheetAt(0);
            Sheet sheet = wb.createSheet(""+date+"#"+date2+"");
            Row row = null;
            Cell cell = null;
            for (int i = 0; i < model.getRowCount(); i++) {
                row = sheet.createRow(i + 2);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    cell = row.createCell(j);
                    cell.setCellValue((String) model.getValueAt(i, j));
                }
            }
            
            fis.close();
            FileOutputStream output = new FileOutputStream("LaporanParkir.xls");
            wb.write(output);
            wb.close();
            output.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Export!");
        } catch (IOException | EncryptedDocumentException | InvalidFormatException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Di Export!", "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void exportExcel() {
        try {
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Laporan");
            Row row = null;
            Cell cell = null;
            //content
            Font contentFont = wb.createFont();
            contentFont.setFontHeightInPoints((short) 12);
            contentFont.setFontName("Times New Roman");
            CellStyle cs = wb.createCellStyle();
            cs.setFont(contentFont);
            cs.setAlignment(HorizontalAlignment.CENTER);
            cs.setBorderBottom(BorderStyle.MEDIUM);
            cs.setBorderTop(BorderStyle.MEDIUM);
            cs.setBorderRight(BorderStyle.MEDIUM);
            cs.setBorderLeft(BorderStyle.MEDIUM);
            //header
            Font headerFont = wb.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);
            headerFont.setFontName("Times New Roman");
            CellStyle head = wb.createCellStyle();
            head.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            head.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            head.setFont(headerFont);
            head.setAlignment(HorizontalAlignment.CENTER);
            head.setBorderBottom(BorderStyle.MEDIUM);
            head.setBorderTop(BorderStyle.MEDIUM);
            head.setBorderRight(BorderStyle.MEDIUM);
            head.setBorderLeft(BorderStyle.MEDIUM);
            
            for (int hd = 0; hd < 7; hd++) {
                row = sheet.createRow(1);
                for (int i = 0; i < 7; i++) {
                    cell = row.createCell(i);
                    cell.setCellValue(headers[i]);
                    cell.setCellStyle(head);
                }
            }
            for (int i = 0; i < model.getRowCount(); i++) {
                row = sheet.createRow(i + 2);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    cell = row.createCell(j);
                    cell.setCellValue((String) model.getValueAt(i, j));
                    cell.setCellStyle(cs);
                    sheet.autoSizeColumn(j);
                }
            }
            FileOutputStream out = new FileOutputStream("D:\\"+date+" __ "+date2+".xlsx");
            wb.write(out);
            out.close();
            wb.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Export!");
        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Di Export!", "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }
}
package aplikasi;

import aplikasi.LaporanEntity;
import aplikasi.LaporanJFrame;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class LaporanReporter {
    
    public void show(List<LaporanEntity> laporans){
        try {
            JRBeanCollectionDataSource collectionDataSource=new JRBeanCollectionDataSource(laporans);
            
            InputStream input=LaporanTableModel.class.getResourceAsStream("/jtablereport.jrxml");
            JasperDesign design=JRXmlLoader.load(input);
            JasperReport report=JasperCompileManager.compileReport(design);
            
            JasperPrint jasperPrint=JasperFillManager.fillReport(report, null, collectionDataSource);
            jasperPrint.setName("Laporan");
            
            JasperViewer jv=new JasperViewer(jasperPrint, false);
            jv.setTitle("Laporan Mahasiswa");
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(LaporanReporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
package aplikasi;

import aplikasi.LaporanEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class LaporanTableModel extends AbstractTableModel {
    List<LaporanEntity> laporanentitys = new ArrayList<LaporanEntity>();
    
    public List<LaporanEntity> getLaporanEntitys(){
        return laporanentitys;
    }
    private final String HEADER[]={"Plat Nomor","Nomor Karcis","Jenis Kendaraan","Jam Masuk","Jam Keluar","Durasi Parkir","Harga Kendaraan","Total Bayar"};
    public void save (LaporanEntity laporan) {
        laporanentitys.add(laporan);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }
    
    public int getRowCount() {
        return laporanentitys.size();
    }
    
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      LaporanEntity laporan = laporanentitys.get(rowIndex);
      switch (columnIndex) {
          case 0 : return laporan.getPlatNomor();
          case 1 : return laporan.getNomorKarcis();
          case 2 : return laporan.getJenisKendaraan();
          case 3 : return laporan.getJamMasuk();
          case 4 : return laporan.getJamKeluar();
          case 5 : return laporan.getDurasiParkir();
          case 6 : return laporan.getHargaKendaraan();
          case 7 : return laporan.getTotalBayar();
          default : return null;
      }
    }
}

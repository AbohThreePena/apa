package aplikasi;


public class LaporanEntity {
    private String platNomor;
    private String nomorKarcis;
    private String jenisKendaraan;
    private String jamMasuk;
    private String jamKeluar;
    private String durasiParkir;
    private String hargaKendaraan;
    private String totalBayar;
    //Plat nomor
    public String getPlatNomor() {
    return platNomor;
    }
    public void setPlatNomor(String platNomor) {
    this.platNomor = platNomor;
    }
    //nomor karcis
    public String getNomorKarcis() {
    return nomorKarcis;
    }
    public void setNomorKarcis(String nomorKarcis) {
    this.nomorKarcis = nomorKarcis;
    }
    //jenis Kendaraan
    public String getJenisKendaraan() {
    return jenisKendaraan;
    }
    public void setJenisKendaraan(String jenisKendaraan) {
    this.jenisKendaraan = jenisKendaraan;
    }
    //jam masuk
    public String getJamMasuk() {
    return jamMasuk;
    }
    public void setJamMasuk(String jamMasuk) {
    this.jamMasuk = jamMasuk;
    }
    //jam keluar
    public String getJamKeluar() {
    return jamKeluar;
    }
    public void setJamKeluar (String jamKeluar) {
    this.jamKeluar = jamKeluar;
    }
    //durasi parkir
    public String getDurasiParkir () {
    return durasiParkir;
    }
    public void setDurasiParkir (String durasiParkir) {
    this.durasiParkir = durasiParkir;
    }
    //harga kendaraan
    public String getHargaKendaraan() {
    return hargaKendaraan;
    }
    public void setHargaKendaraan (String hargaKendaraan) {
    this.hargaKendaraan = hargaKendaraan;
    }
    //total bayar
    public String getTotalBayar() {
    return totalBayar;
    }
    public void setTotalBayar (String totalBayar) {
    this.totalBayar = totalBayar;
    }
}
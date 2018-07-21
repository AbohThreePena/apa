package aplikasi;

public class userakses {

    private static String u_kodePegawai;
    private static String u_username;
    private static String u_password;
    private static String u_nama;
    private static String u_levelUser;
    private static byte u_fotoUser;

    
    public static String getU_kodePegawai() {
        return u_kodePegawai;
    }

    public static void setU_kodePegawai(String u_kodePegawai) {
        userakses.u_kodePegawai = u_kodePegawai;
    }

    public static String getU_username() {
        return u_username;
    }

    public static void setU_username(String u_username) {
        userakses.u_username = u_username;
    }

    public static String getU_password() {
        return u_password;
    }

    public static void setU_password(String u_password) {
        userakses.u_password = u_password;
    }

    public static String getU_nama() {
        return u_nama;
    }

    public static void setU_nama(String u_nama) {
        userakses.u_nama = u_nama;
    }

    public static String getU_levelUser() {
        return u_levelUser;
    }

    public static void setU_levelUser(String u_levelUser) {
        userakses.u_levelUser = u_levelUser;
    }
    public static byte getU_fotoUser() {
        return u_fotoUser;
    }
    public static void setU_fotoUser(byte u_fotoUser) {
        userakses.u_fotoUser = u_fotoUser;
    }
}
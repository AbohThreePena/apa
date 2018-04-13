    package koneksi;

        import java.sql.DriverManager;
        import java.sql.Connection;
        import java.sql.SQLException;
        import java.util.logging.Level;
        import java.util.logging.Logger;
        import java.sql.Statement;
        
/**
 *
 * @author IT Departement
 */
public class koneksiDB {
    private static Connection koneksi;
    public static Connection getConnection() throws SQLException {
        if(koneksi==null){
           try {
               String url = "jdbc:mysql://localhost:3306/axia_parkir";
               String usr = "root";
               String pwd = "";
               DriverManager.registerDriver(new com.mysql.jdbc.Driver());
               koneksi = DriverManager.getConnection(url, usr, pwd);
           } catch(SQLException ex) {
               Logger.getLogger(koneksiDB.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
        return koneksi;
}  
}


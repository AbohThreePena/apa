package main;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.splashscreen;
import aplikasi.Frame_Login;

/**
 *
 * @author IT Departement
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {   
            new splashscreen().setVisible(true);//memanggil splashscreen   
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Singgih
 */
public class userakses {
    private static String username,JLevelUser;
    
 
public static void setUserLogin(String Username) {
    userakses.username = Username;
}
public static String getUserLogin() {
return username;
}   
public static void setstatus(String Status) {
    userakses.JLevelUser = Status;
}
public static String getstatus() {
return JLevelUser;
}   
}
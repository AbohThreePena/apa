package com.parkirmasuk;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class parkirMasuk {
    
    PanamaHitek_Arduino io = new PanamaHitek_Arduino();
    SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent serialPortEvent) {
            try {
                while (io.isMessageAvailable()) {                    
                    System.out.print("1");
                    break;
                }
            } catch (Exception e) {
                java.util.logging.Logger.getLogger(parkirMasuk.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    };
    
    public parkirMasuk() {
    initComponents();
        try {
            io.arduinoRXTX("COM1", 9600, listener);
        } catch (Exception e) {
            
        }
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new parkirMasuk();
            }
    });
    }

    private void initComponents() {
        
    }
    
}

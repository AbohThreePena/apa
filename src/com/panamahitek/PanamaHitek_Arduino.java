package com.panamahitek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jssc.*;
import static jssc.SerialPort.PURGE_RXCLEAR;
import static jssc.SerialPort.PURGE_TXCLEAR;


public class PanamaHitek_Arduino {

    private SerialPort serialPort;
    private SerialPortEventListener events = null;
    private String connection = "";
    private String portName = "";
    private static int BYTESIZE = 8;
    private static int STOPBITS = 1;
    private static int PARITY = 0;
    private static int TIMEOUT = 2000;
    private String message = "";
    private boolean messageAvailable = false;
    private boolean availableInUse = false;

    public PanamaHitek_Arduino() {
//        PanamaHitek();
    }


    private void PanamaHitek() {
        System.out.println("PanamaHitek_Arduino Library, version 3.0.0");
        System.out.println("==============================================");
        System.out.println("Created by Antony Garcia Gonzalez");
        System.out.println("Electromechanical Engineer and creator of Project Panama Hitek");
        System.out.println("This library has been created from Java Simple Serial Connector, by Alexey Sokolov");
        System.out.println("You can find all the information about this library at http://panamahitek.com");
    }
    
    public void setParity(int input_Parity) {

        if ((input_Parity >= 0) && (input_Parity <= 4)) {
            PARITY = input_Parity;
        } else {
            PARITY = 0;
                System.out.println("Parity can only be: \n"
                    + "0 = Without Parity\n"
                    + "1 = Odd Parity\n"
                    + "2 = Parity Par\n"
                    + "3 = Marked Parity\n"
                    + "4 = Spaced Parity\n"
                    + "Default parity is maintained (0- No Parity)");
        }
    }

    public void setByteSize(int Bytes) {

        if ((Bytes >= 5) && (Bytes <= 8)) {
            BYTESIZE = Bytes;
        } else {
            BYTESIZE = 8;
            System.out.println("Only values between 5 and 8 are accepted for the ByteSize "
                    + "\nThe default value is retained (8 bytes)");
        }
    }

    public void setStopBits(int Bits) {

        if ((Bits >= 1) && (Bits <= 3)) {
            STOPBITS = Bits;
        } else {
            STOPBITS = 1;
            System.out.println("Only values between 1 and 3 are accepted for StopBit (3 is for 1.5 StopBits)."
                    + "\nThe default value is retained (1 Bit)");
        }
    }

    public void setTimeOut(int time) {
        this.TIMEOUT = time;
    }

    public void arduinoTX(String PORT_NAME, int DATA_RATE) throws ArduinoException {
        if (connection.equals("")) {
            connection = "TX";
        } else {
            throw new ArduinoException(portName, "arduinoTX()", ArduinoException.TYPE_RXTX_EXCEPTION);
        }

        try {
            this.portName = PORT_NAME;
            serialPort = new SerialPort(PORT_NAME);
            serialPort.openPort();
            serialPort.setParams(DATA_RATE, BYTESIZE, STOPBITS, PARITY);
            flushSerialPort();
        } catch (SerialPortException ex) {
            throw new ArduinoException(portName, "arduinoTX()", ArduinoException.TYPE_PORT_NOT_OPENED);
        }

    }

    public void arduinoRXTX(String PORT_NAME, int DATA_RATE, SerialPortEventListener events) throws ArduinoException {
        if (connection.equals("")) {
            connection = "RXTX";
        } else {
            throw new ArduinoException(portName, "arduinoRXTX()", ArduinoException.TYPE_RXTX_EXCEPTION);
        }
        try {
            this.portName = PORT_NAME;
            serialPort = new SerialPort(PORT_NAME);
            serialPort.openPort();
            serialPort.setParams(DATA_RATE, BYTESIZE, STOPBITS, PARITY);
            serialPort.addEventListener(events);
            flushSerialPort();
        } catch (SerialPortException ex) {
            throw new ArduinoException(portName, "arduinoRXTX()", ArduinoException.TYPE_PORT_NOT_OPENED);
        }

    }

    public void arduinoRX(String PORT_NAME, int DATA_RATE, SerialPortEventListener events) throws ArduinoException, SerialPortException {

        if (connection.equals("")) {
            connection = "RX";
        } else {
            throw new ArduinoException(portName, "arduinoRX()", ArduinoException.TYPE_RXTX_EXCEPTION);
        }
        try {
            this.portName = PORT_NAME;
            serialPort = new SerialPort(PORT_NAME);
            serialPort.openPort();
            serialPort.setParams(DATA_RATE, BYTESIZE, STOPBITS, PARITY);
            serialPort.addEventListener(events);
            flushSerialPort();
        } catch (SerialPortException ex) {
            throw new ArduinoException(portName, "arduinoRX()", ArduinoException.TYPE_PORT_NOT_OPENED);
        }
    }

    public void sendData(String data) throws ArduinoException, SerialPortException {
        if (connection.equals("RX")) {
            throw new ArduinoException(portName, "sendData()", ArduinoException.TYPE_WRONG_SEND_DATA_CONNECTION);
        } else if (connection.equals("")) {
            throw new ArduinoException(portName, "sendData()", ArduinoException.TYPE_SEND_DATA);
        } else if (connection.equals("TX") || connection.equals("RXTX")) {
            serialPort.writeBytes(data.getBytes());
        }
    }

    public void sendByte(int data) throws ArduinoException, SerialPortException {

        if (connection.equals("RX")) {
            throw new ArduinoException(portName, "sendByte()", ArduinoException.TYPE_SEND_DATA);
        } else if (connection.equals("")) {
            throw new ArduinoException(portName, "sendByte()", ArduinoException.TYPE_NO_ARDUINO_CONNECTION);
        } else if (connection.equals("TX") || connection.equals("RXTX")) {
            serialPort.writeByte((byte) data);
        }

    }
    public byte[] receiveData() throws ArduinoException, SerialPortException {
        if (connection.equals("TX")) {
            throw new ArduinoException(portName, "receiveData()", ArduinoException.TYPE_RECEIVE_DATA);
        } else if (connection.equals("")) {
            throw new ArduinoException(portName, "receiveData()", ArduinoException.TYPE_NO_ARDUINO_CONNECTION);
        } else {
            return serialPort.readBytes();
        }
    }

    public boolean isMessageAvailable() throws SerialPortException, ArduinoException {
        availableInUse = true;
        serialRead();
        return messageAvailable;
    }
    private void serialRead() throws ArduinoException, SerialPortException {
        int inputByte;
        byte[] buffer = receiveData();
        if (buffer != null) {
            int bufferLength = buffer.length;
            if (!messageAvailable) {
                for (int i = 0; i < bufferLength; i++) {
                    inputByte = buffer[i];
                    if (inputByte > 0) {
                        if (inputByte != 13) {
                            if (inputByte != 10) {
                                message = message + (char) inputByte;
                            } else {
                                messageAvailable = true;
                            }
                        }
                    }
                }
            }
        }
    }

    public String printMessage() throws SerialPortException, ArduinoException {
        String output = "No data available";
        if (!availableInUse) {
            serialRead();
        }
        if (isMessageAvailable()) {
            output = message;
            message = "";
            messageAvailable = false;
        }
        return output;
    }

    public int getPortsAvailable() {
        return SerialPortList.getPortNames().length;
    }

    public List<String> getSerialPorts() {
        List<String> ports = new ArrayList<>();
        String[] portNames = SerialPortList.getPortNames();
        ports.addAll(Arrays.asList(portNames));
        return ports;
    }

    public void killArduinoConnection() throws ArduinoException {
        if (connection.equals("")) {
            throw new ArduinoException(this.portName, "killArduinoConnection()", ArduinoException.TYPE_KILL_ARDUINO_CONNECTION);
        } else {
            try {
                serialPort.closePort();
            } catch (SerialPortException ex) {
                throw new ArduinoException(portName, "killArduinoConnection()", ArduinoException.TYPE_CLOSE_PORT);
            }
            connection = "";
            System.out.println("Connection with Finished Arduino");
        }
    }
    public void flushSerialPort() throws SerialPortException {
        serialPort.purgePort(PURGE_RXCLEAR);
        serialPort.purgePort(PURGE_TXCLEAR);
    }
    public int getInputBytesAvailable() throws SerialPortException {
        return serialPort.getInputBufferBytesCount();
    }
    public SerialPortEventListener getEventListener() throws ArduinoException {
        if (events != null) {
            return events;
        } else {
            throw new ArduinoException(portName, "getEventListener()", ArduinoException.TYPE_NO_EVENT_LISTENER);
        }
    }
}

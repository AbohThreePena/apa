package com.panamahitek;

public class ArduinoException extends Exception {

    private static String portName;
    private static String methodName;
    private static String exceptionType;

    final public static String TYPE_PORT_ALREADY_OPENED = "Port yang Anda coba buka digunakan oleh perangkat lain";
    final public static String TYPE_PORT_NOT_OPENED = "Port not opened";
    final public static String TYPE_RXTX_EXCEPTION = "Unable to start the connection with Arduino 2 times";
    final public static String TYPE_NO_ARDUINO_AT_PORT = "No Arduino was found connected to this port. Check the port on which Arduino is connected";
    final public static String TYPE_NO_SERIAL_PORT = "No Arduino has been found connected to this computer. Please connect Arduino to the PC via USB";
    final public static String TYPE_PORT_USED_BY_OTHER_APP = "Impossible to connect. This port has a connection to another application";
    final public static String TYPE_SEND_DATA = "Impossible to connect. This port has a connection to another application";
    final public static String TYPE_SEND_DATA_ERROR = "Error in sending data";
        final public static String TYPE_WRONG_SEND_DATA_CONNECTION = "The sendData () method can not be used if the Arduino connection has been started with the arduinoRX () method, which is only for receiving data";
    final public static String TYPE_NO_ARDUINO_CONNECTION = "No connection has been established with Arduino. Please use one of the methods arduinoRX (), arduinoTX () or arduinoRXTX ()";
    final public static String TYPE_KILL_ARDUINO_CONNECTION = "Connection with Arduino can not be terminated if it has not been started";
    final public static String TYPE_CLOSE_PORT = "Error ending connection with Arduino";
    final public static String TYPE_RECEIVE_DATA = "The receiveData () method can not be used if the Arduino connection has been initiated with the ArduinoTX () method, which is only for receiving data";
    final public static String TYPE_NO_EVENT_LISTENER = "An EventListener has not been added to the PanamaHitek_Arduino class";

    public ArduinoException(String portName, String methodName, String exceptionType) {
        super("Name of the port - " + portName + "; Name of the method - " + methodName + "; Type of exception - " + exceptionType + ".");
        this.portName = portName;
        this.methodName = methodName;
        this.exceptionType = exceptionType;
    }

    public static String getExceptionType() {
        return exceptionType;
    }

    public static void setExceptionType(String exceptionType) {
        ArduinoException.exceptionType = exceptionType;
    }

    public static String getMethodName() {
        return methodName;
    }

    public static void setMethodName(String methodName) {
        ArduinoException.methodName = methodName;
    }

    public static String getPortName() {
        return portName;
    }

    public static void setPortName(String portName) {
        ArduinoException.portName = portName;
    }

}

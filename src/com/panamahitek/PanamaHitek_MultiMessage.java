package com.panamahitek;

import java.util.ArrayList;
import java.util.List;
import jssc.SerialPortException;

public class PanamaHitek_MultiMessage {

    //Variables 
    private static int inputMesages = 0;
    private static List<String> inputBuffer;
    private final PanamaHitek_Arduino arduinoObject;

    public PanamaHitek_MultiMessage(int inputMessages, PanamaHitek_Arduino arduinoObject) {
        this.arduinoObject = arduinoObject;
        inputMesages = inputMessages;
        inputBuffer = new ArrayList<>();
    }

    public boolean dataReceptionCompleted() throws ArduinoException, SerialPortException {
           String str = "";
        int i = 0;

        if (arduinoObject.getInputBytesAvailable() > 0) {
            while (i < inputMesages) {
                if (arduinoObject.getInputBytesAvailable() > 0) {
                    byte[] buffer = arduinoObject.receiveData();
                    int bufferLenth = buffer.length;
                    for (int j = 0; j < bufferLenth; j++) {
                        int n = buffer[j];
                        if (n != 10 && n != 13) {
                            str += (char) n;
                        } else {
                            str += n;
                            if (str.contains("1310")) {
                                inputBuffer.add(str.replaceAll("1310", ""));
                                i++;
                                str = "";
                            }
                        }
                    }
                }

            }
            return true;
        } else {
            return false;
        }
    }

    public String getMessage(int index) {
        String Output = inputBuffer.get(index);
        return Output;
    }

    public List<String> getMessageList() {
        return inputBuffer;
    }

    public void flushBuffer() {
        inputBuffer.clear();
    }
}

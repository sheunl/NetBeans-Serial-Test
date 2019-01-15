/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netbeans.serial.test;

/**
 *
 * @author Oluwasheun
 */
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class NetBeansSerialTest {

    /**
     * @param args the command line arguments
     */
    private static String lcd_text = "Data from a Java Applications";
    private static String thePort = "None"; //the value of the port for the Arduino
    
      public static int run_comms()
    {
        SerialPort serialPort = new SerialPort(thePort);
        
        
        try {
            serialPort.openPort(); //
            serialPort.setParams(SerialPort.BAUDRATE_9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1, SerialPort.PARITY_NONE,false,false);
          //serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
          if(lcd_text.length()>32){ lcd_text ="String must be  less than 32"; }
         
            serialPort.writeBytes(lcd_text.getBytes());
           // serialPort.writeString("\n\ryu");
         // serialPort.writeString("556");
           serialPort.closePort(); 
           System.out.println("Done");
           
        }
        catch (SerialPortException ex){
            System.out.println(ex);
        }
         return 100;
    }
    
     public void upToLcd(String text){
         lcd_text = text;
         run_comms();
         
     }
     
     public String[] getSerialPorts()
     {
             String[] portNames = SerialPortList.getPortNames();
    for(int i = 0; i < portNames.length; i++){
        System.out.println(portNames[i]);
    }
    
    
    return portNames;
     }
     
     public void setPort(String port)
     {
         thePort = port;
     }
             
}

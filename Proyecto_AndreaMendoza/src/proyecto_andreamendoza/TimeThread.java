package proyecto_andreamendoza;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class TimeThread implements Runnable {
 private JLabel Hora;
 
 public TimeThread(JLabel Hora) {
     this.Hora = Hora;
 }
 
 public void run() {
     while (true) {
         Date h = new Date();
         DateFormat f = new SimpleDateFormat("hh:mm a");
         Hora.setText(f.format(h));
         try {
             Thread.sleep(50);
         } catch (Exception e) {
             
         }
     }
 }
}

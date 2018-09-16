package proyecto_andreamendoza;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Reminders extends Thread {

    boolean go;
    Date ref;

    public Reminders() {
    }

    public Reminders(Date ref) {
        this.ref = ref;
        go = true;
    }

    public boolean isGo() {
        return go;
    }

    public void setGo(boolean go) {
        this.go = go;
    }

    public Date getRef() {
        return ref;
    }

    public void setRef(Date ref) {
        this.ref = ref;
    }

    public void run() {
        while (go) {
            Date now = new Date();
            if (now.toString().equals(ref.toString())) {             
                JOptionPane.showMessageDialog(null,"¡¡Tiene una actividad pendiente!!");
                go = false;
                this.stop();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

}

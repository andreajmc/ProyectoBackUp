package proyecto_andreamendoza;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class BarMusic extends Thread {

    private JProgressBar barra;
    private boolean avanzar;
    private boolean vive;

    public BarMusic(JProgressBar barra) {
        this.barra = barra;
        this.avanzar = false;
        this.vive = true;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public boolean isAvanzar() {
        return avanzar;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

    public void run() {
        while (vive) {
            if (avanzar) {
                barra.setValue(barra.getValue() + 1);
                if (barra.getValue() == barra.getMaximum()) {
                    vive = false;
                    barra.setValue(0);
                    break; //*
                }
            }
            try {
                Thread.sleep(600); //*
            } catch (Exception ex) {     
            }
        }
    }
}

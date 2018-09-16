package proyecto_andreamendoza;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Tareas extends Actividades {

    private String contenido;
    private ArrayList<File> notes;
    private Date rem;

    public Tareas(String contenido, ArrayList<File> notes, Date date, String title, boolean reminder, int mins) {
        super(date, title, reminder, mins);
        this.contenido = contenido;
        this.notes = notes;
        setRec(date);
        Reminders r = new Reminders(rem);
        r.start();
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public ArrayList<File> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<File> notes) {
        this.notes = notes;
    }

    public void addNotes(File n) {
        this.notes.add(n);
    }

    @Override
    public Date getRec() {
        return rem;
    }

    @Override
    public void setRec(Date d) {
        int ms = mins * 60000;
        rem = new Date(d.getTime() - ms);
    }

}
    

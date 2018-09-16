package proyecto_andreamendoza;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Tareas extends Actividades{
private String contenido;
private ArrayList <File> notes;

    public Tareas(String contenido, ArrayList<File> notes, Date date, String title, boolean reminder, int mins) {
        super(date, title, reminder, mins);
        this.contenido = contenido;
        this.notes = notes;
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


}

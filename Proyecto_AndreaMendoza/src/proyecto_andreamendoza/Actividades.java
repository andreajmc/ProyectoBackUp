package proyecto_andreamendoza;

import java.io.Serializable;
import java.util.Date;

public abstract class Actividades implements Serializable {

    protected Date date;
    protected String title;
    protected boolean reminder;
    protected int mins;


    public Actividades(Date date, String title, boolean reminder, int mins) {
        this.date = date;
        this.title = title;
        this.reminder = reminder;
        this.mins = mins;
        setRec(date);
    }
   
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    public int getMins() {
        return mins;
    }

    public void setMins(int mins) {
        this.mins = mins;
    }

    public abstract Date getRec();
    public abstract void setRec(Date d);

    @Override
    public String toString() {
        return title;
    }

}

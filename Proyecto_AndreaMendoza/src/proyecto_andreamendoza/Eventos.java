package proyecto_andreamendoza;

import java.util.Date;

public class Eventos extends Actividades {

    private Date start;
    private Date end;
    private Date rem;

    public Eventos(Date start, Date end, Date date, String title, boolean reminder, int mins) {
        super(date, title, reminder, mins);
        this.start = start;
        this.end = end;
        setRec(this.start);
        Reminders r = new Reminders(rem);
        r.start();
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getRem() {
        return rem;
    }

    public void setRem(Date rem) {
        this.rem = rem;
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

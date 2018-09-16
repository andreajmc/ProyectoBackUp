package proyecto_andreamendoza;

import java.util.Date;

public class Eventos extends Actividades {
    private String start;
    private String end;

    public Eventos(String start, String end, Date date, String title, boolean reminder, int mins) {
        super(date, title, reminder, mins);
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
    
    
}

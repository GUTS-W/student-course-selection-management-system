package obProject.entity;
import java.util.Date;
public class course_time {
    private String cid;
    private int weekday;
    private int session;

    public course_time(String cid, int weekday, int session) {
        this.cid = cid;
        this.weekday = weekday;
        this.session = session;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }
}
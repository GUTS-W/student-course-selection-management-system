package obProject.entity;

public class select_course {
    private String sid;
    private String cid;
    private int score;

    public select_course(String sid, String cid, int score) {
        this.sid = sid;
        this.cid = cid;
        this.score = score;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

package obProject.entity;

public class course_score {
    private String cid;
    private String sid;
    private String cname;
    private int score;
    private String type;
    private int credit;


    public course_score(String cid, String sid, String cname, int score, String type, int credit) {
        this.cid = cid;
        this.sid = sid;
        this.cname = cname;
        this.score = score;
        this.type = type;
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

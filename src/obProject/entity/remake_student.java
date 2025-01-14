package obProject.entity;

public class remake_student {
    String sid;
    String cid;
    String cname;
    String if_pass;

    public remake_student(String sid, String cid, String cname, String if_pass) {
        this.sid = sid;
        this.cid = cid;
        this.cname = cname;
        this.if_pass = if_pass;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getIf_pass() {
        return if_pass;
    }

    public void setIf_pass(String if_pass) {
        this.if_pass = if_pass;
    }
}

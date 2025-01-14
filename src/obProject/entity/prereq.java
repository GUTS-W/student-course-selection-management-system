package obProject.entity;

public class prereq {
    private String cid;
    private String pre_cid;

    public prereq(String cid, String pre_cid) {
        this.cid = cid;
        this.pre_cid = pre_cid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPre_cid() {
        return pre_cid;
    }

    public void setPre_cid(String pre_cid) {
        this.pre_cid = pre_cid;
    }
}

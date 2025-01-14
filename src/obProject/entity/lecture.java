package obProject.entity;

public class lecture {
    private String tid;
    private String cid;
    private String department;
    private int credit;
    private String cname;
    private String type;
    private String target_department;
    private String tname;
    private String approval;//审批结果展示   涉及er图和关系表修改
    private int weekday;
    private int session;

    private String rid;
    private String campus;
    private String building;

    public lecture(String tid, String cid, String department, int credit, String cname, String type, String target_department, String tname, String approval, int weekday, int session, String rid, String campus, String building) {
        this.tid = tid;
        this.cid = cid;
        this.department = department;
        this.credit = credit;
        this.cname = cname;
        this.type = type;
        this.target_department = target_department;
        this.tname = tname;
        this.approval = approval;
        this.weekday = weekday;
        this.session = session;
        this.rid = rid;
        this.campus = campus;
        this.building = building;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
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

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTarget_department() {
        return target_department;
    }

    public void setTarget_department(String target_department) {
        this.target_department = target_department;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }
}

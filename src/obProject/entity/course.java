package obProject.entity;

public class course {
    private String cid;
    private String department_id;
    private int credit;
    private String name;
    private String type;
    private String target_department_id;


    public course(String cid, String department_id, int credit, String name, String type, String target_department_id) {
        this.cid = cid;
        this.department_id = department_id;
        this.credit = credit;
        this.name = name;
        this.type = type;
        this.target_department_id = target_department_id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getTarget_department_id() {
        return target_department_id;
    }

    public void setTarget_department_id(String target_department_id) {
        this.target_department_id = target_department_id;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
package obProject.entity;

public class classroom {
    private String rid;
    private String campus;
    private String building;

    public classroom(String rid, String campus, String building) {
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
}

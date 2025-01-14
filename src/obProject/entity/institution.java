package obProject.entity;

public class institution {
    private String campus;
    private String mid;
    private String grade;
    private String class_1;//class
    private String sid;


    public institution(String campus, String mid, String grade, String class_1, String sid) {
        this.campus = campus;
        this.mid=mid;
        this.grade = grade;
        this.class_1 = class_1;
        this.sid = sid;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getMID() {
        return mid;
    }

    public void setMID(String mid) {
        this.mid = mid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClass_1() {
        return class_1;
    }

    public void setClass_1(String class_1) {
        this.class_1 = class_1;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}

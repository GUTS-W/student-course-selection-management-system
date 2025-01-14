package obProject.entity;

import java.util.Date;

public class student {
    private String sid;
    private String id;
    private Date birthday;//date
    private String name;
    private String sex;
    private String password;

    public student(String sid, String id, Date birthday, String name, String sex, String password) {
        this.sid = sid;
        this.id = id;
        this.birthday = birthday;
        this.name = name;
        this.sex = sex;
        this.password = password;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

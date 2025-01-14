package obProject.entity;

import java.io.Serializable;
public class administrators {
    private String aid;
    private String password;

    public administrators(String aid, String password) {
        this.aid = aid;
        this.password = password;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
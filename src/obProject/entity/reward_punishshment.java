package obProject.entity;

public class reward_punishshment {
    private String sid;
    private String level;
    private String type;
    private String name;
    private String is_pass;

    public reward_punishshment(String sid, String level, String type, String name,String is_pass) {
        this.sid = sid;
        this.level = level;
        this.type = type;
        this.name = name;
        this.is_pass=is_pass;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIs_pass() {
        return is_pass;
    }

    public void setIs_pass(String is_pass) {
        this.is_pass = is_pass;
    }
}

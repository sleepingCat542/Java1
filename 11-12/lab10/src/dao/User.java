package dao;

import java.util.Date;

public class User {
    private int id;
    private String login;
    private String password;
    private ROLE role;
    private Date lastLogin;
    private int timesLogin;

    public User() {
    }

    public User(int id, String login, String password, ROLE role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.lastLogin=new Date();
        this.timesLogin=1;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getTimesLogin() {
        return timesLogin;
    }

    public void setTimesLogin(int timesLogin) {
        this.timesLogin = timesLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public enum ROLE {
        USER, ADMIN, UNKNOWN
    }
}

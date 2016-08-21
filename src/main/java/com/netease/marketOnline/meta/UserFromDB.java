package com.netease.marketOnline.meta;

/**
 * Created by wxr on 16-8-21.
 */
public class UserFromDB {
    private int id;
    private String username;
    private int usertype;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserFromDB{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", usertype=" + usertype +
                ", password='" + password + '\'' +
                '}';
    }
}

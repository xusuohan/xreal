package com.xreal.entity;

public class User {
    private int id;
    private String username;
    private String password;
    private String state;
    private String create_time;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getState() {
        return state;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }


}

package com.example.luo.loginandlogout.data.modules;

public class User {

    private String userName;

    private String userIconUrl;

    private byte age;

    private String email;

    public User() {
    }

    public User(String userName, String userIconUrl, byte age, String email) {
        this.userName = userName;
        this.userIconUrl = userIconUrl;
        this.age = age;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIconUrl() {
        return userIconUrl;
    }

    public void setUserIconUrl(String userIconUrl) {
        this.userIconUrl = userIconUrl;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

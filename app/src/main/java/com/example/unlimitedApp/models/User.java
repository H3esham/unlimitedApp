package com.example.unlimitedApp.models;

public class User {

    private String email;
    private String password;
    private Integer age;
    private String fullName;


    public User(String fullName, String email, String password, Integer age) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.age = (Integer) age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

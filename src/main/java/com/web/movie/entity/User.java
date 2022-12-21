package com.web.movie.entity;

public class User {
    private int userId;
    private String userName;
    private String passWord;
    private String QQNumber;
    private String email;
    private int age;

    public User(){
        this.userName="";
        this.passWord="";
        this.QQNumber="";
        this.email="";
        this.age=0;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getQQNumber() {
        return QQNumber;
    }

    public void setQQNumber(String QQNumber) {
        this.QQNumber = QQNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", QQNumber='" + QQNumber + '\'' +
                ", age=" + age +
                '}';
    }
}

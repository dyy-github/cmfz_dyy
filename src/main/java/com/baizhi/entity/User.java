package com.baizhi.entity;

import java.util.Date;
import java.util.List;

public class User {
    private String id;
    private String phoneNum;
    private String username;
    private String password;
    private String salt;//盐
    private String city;
    private String province;//省
    private String nickName;//法名
    private String gender;//性别
    private String headPic;//头像
    private String status;//状态
    private String sign;
    private Date date;
    private List<Course> courses;

    public User() {
    }

    public User(String id, String phoneNum, String username, String password, String salt, String city, String province, String nickName, String gender, String headPic, String status, String sign, Date date, List<Course> courses) {
        this.id = id;
        this.phoneNum = phoneNum;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.city = city;
        this.province = province;
        this.nickName = nickName;
        this.gender = gender;
        this.headPic = headPic;
        this.status = status;
        this.sign = sign;
        this.date = date;
        this.courses = courses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender='" + gender + '\'' +
                ", headPic='" + headPic + '\'' +
                ", status='" + status + '\'' +
                ", sign='" + sign + '\'' +
                ", date=" + date +
                ", courses=" + courses +
                '}';
    }
}

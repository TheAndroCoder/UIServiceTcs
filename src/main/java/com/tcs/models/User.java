package com.tcs.models;




import java.sql.Date;
import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String userid;
    private String email;
    private String username;
    private String password;
    private String mobile;
    private String dob;
    private String security_answer;
    private java.util.Date addedon,lastmodified;
    private java.util.Date lastlogin;
    private int status,type,security_question_id;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSecurity_answer() {
        return security_answer;
    }

    public void setSecurity_answer(String security_answer) {
        this.security_answer = security_answer;
    }

    public java.util.Date getAddedon() {
        return addedon;
    }

    public void setAddedon(java.util.Date addedon) {
        this.addedon = addedon;
    }

    public java.util.Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(java.util.Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    public java.util.Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(java.util.Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSecurity_question_id() {
        return security_question_id;
    }

    public void setSecurity_question_id(int security_question_id) {
        this.security_question_id = security_question_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", dob='" + dob + '\'' +
                ", security_answer='" + security_answer + '\'' +
                ", addedon=" + addedon +
                ", lastmodified=" + lastmodified +
                ", lastlogin=" + lastlogin +
                ", status=" + status +
                ", type=" + type +
                ", security_question_id=" + security_question_id +
                '}';
    }
}
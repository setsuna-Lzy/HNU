package com.setsuna.springboot.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private Integer id;
    private String stu_no;
    private String stu_name;
    private String sex;
    private Date birth;
    private String department;
    private String addr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStu_no() {
        return stu_no;
    }

    public void setStu_no(String stu_no) {
        this.stu_no = stu_no;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String std_name) {
        this.stu_name = std_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(String birth) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.birth = format.parse(birth);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public User(Integer id, String stu_no, String stu_name, String sex, Date birth, String department, String addr) {
        this.id = id;
        this.stu_no = stu_no;
        this.stu_name = stu_name;
        this.sex = sex;
        this.birth = birth;
        this.department = department;
        this.addr = addr;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", stu_no='" + stu_no + '\'' +
                ", std_name='" + stu_name + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", department='" + department + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}

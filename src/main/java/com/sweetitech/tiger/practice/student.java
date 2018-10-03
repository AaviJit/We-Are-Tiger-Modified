package com.sweetitech.tiger.practice;

public class student {

    private Integer id;
    private String name;
    private String roll;
    private String mobile;

    public student(Integer id, String name, String roll, String mobile) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.mobile = mobile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roll='" + roll + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}

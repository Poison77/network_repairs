package com.uic.pojo;

/**
 * 学生维修信息扩展类
 */
public class RepairRecordCustom {
    private String name;
    private String phone;
    private String dorm;
    private Student student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDorm() {
        return dorm;
    }

    public void setDorm(String dorm) {
        this.dorm = dorm;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "RepairRecordCustom{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", dorm='" + dorm + '\'' +
                ", student=" + student +
                '}';
    }
}

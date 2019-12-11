package cn.edu.zjut.po;

import org.apache.ibatis.type.Alias;

import java.sql.Date;

@Alias("checkCustomer")
public class CheckCustomer {
    private Integer no; // 序号
    private String customerId; // 身份证号
    private String name; // 姓名
    private Boolean gender; // 性别
    private String phone; // 手机号
    private Date checkInTime; // 入住时间
    private Date leaveTime; // 离开时间
    private Room room; // 一个入住顾客对应一件房间

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "CheckCustomer{" +
                "no=" + no +
                ", customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", checkInTime=" + checkInTime +
                ", leaveTime=" + leaveTime +
                ", room='" + room.getRoomId() + '\'' +
                '}';
    }
}

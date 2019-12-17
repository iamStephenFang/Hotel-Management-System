package cn.edu.zjut.po;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("customerOrder")
public class CustomerOrder {
    private Integer orderId; // 订单号
    private String customerId; // 身份证号
    private Room room; // 房间号
    private Date checkInTime; // 入住时间
    private Date leaveTime; // 离开时间
    private Boolean living; // 是否离开房间，1 表示未离开， 0 表示离开

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public Boolean getLiving() {
        return living;
    }

    public void setLiving(Boolean living) {
        this.living = living;
    }
}

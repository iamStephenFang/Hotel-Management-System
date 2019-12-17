package cn.edu.zjut.po;

import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

@Alias("order")
public class Order {
    private Integer orderId; // 订单号
    private String roomType; // 房间类型
    private Date orderTime; // 下单时间
    private Date checkInTime; // 入住时间
    private Date leaveTime; // 离开时间
    private Double payment; // 订单费用
    private Integer roomNum; // 房间数量
    private String orderDetail; //订单备注
    private Register register; // 一个订单对应一个注册会员
    private Boolean orderStatus; // 订单状态， 0 未完成，1 进行中，2 已完成
    private List<CheckCustomer> checkCustomers; // 一个订单对应多个入住房客

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public Boolean getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Boolean orderStatus) {
        this.orderStatus = orderStatus;
    }
    public List<CheckCustomer> getCheckCustomers() {
        return checkCustomers;
    }

    public void setCheckCustomers(List<CheckCustomer> checkCustomers) {
        this.checkCustomers = checkCustomers;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", roomType='" + roomType + '\'' +
                ", orderTime=" + orderTime +
                ", checkInTime=" + checkInTime +
                ", leaveTime=" + leaveTime +
                ", payment=" + payment +
                ", roomNum=" + roomNum +
                ", orderDetail='" + orderDetail + '\'' +
                ", register=" + register +
                ", orderStatus=" + orderStatus +
                ", checkCustomers=" + checkCustomers +
                '}';
    }
}

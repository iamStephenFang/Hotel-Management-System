package cn.edu.zjut.po;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("checkCusExtOrder")
public class CheckCustomerExtendsOrder extends CheckCustomer {
    private String orderId;
    private String roomType;
    private Boolean orderStatus;
    private String orderDetail;
    private Date checkInTime;
    private Date leaveTime;
    private String roomId;

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public String getRoomType() {
        return roomType;
    }

    public void setOrderStatus(Boolean orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Boolean getOrderStatus() {
        return orderStatus;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }
    public String getOrderDetail() {
        return orderDetail;
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

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "CheckCustomerExtendsOrder{" +
                "orderId='" + orderId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderDetail='" + orderDetail + '\'' +
                ", checkInTime=" + checkInTime +
                ", leaveTime=" + leaveTime +
                ", roomId='" + roomId + '\'' +
                "} ";
    }
}

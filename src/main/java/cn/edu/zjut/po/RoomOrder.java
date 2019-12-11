package cn.edu.zjut.po;

import org.apache.ibatis.type.Alias;

@Alias("roomOrder")
public class RoomOrder {
    private Integer orderId; // 订单号
    private String roomId; // 房间号
    private Integer orderStatus; // 订单备注

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}

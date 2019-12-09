package cn.edu.zjut.po;

import java.io.Serializable;

public class RoomOrderPK implements Serializable {
    private Integer orderId;
    private String roomId;

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
}

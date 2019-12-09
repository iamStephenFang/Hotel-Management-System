package cn.edu.zjut.po;

import java.util.Collection;

public class Room {
    private String roomId;
    private String roomType;
    private String roomDetail;
    private Byte roomStatus;
    private Collection<CheckCustomer> checkCustomersByRoomId;
    private RoomType roomTypeByRoomType;
    private Collection<RoomOrder> roomOrdersByRoomId;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomDetail() {
        return roomDetail;
    }

    public void setRoomDetail(String roomDetail) {
        this.roomDetail = roomDetail;
    }

    public Byte getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Byte roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Collection<CheckCustomer> getCheckCustomersByRoomId() {
        return checkCustomersByRoomId;
    }

    public void setCheckCustomersByRoomId(Collection<CheckCustomer> checkCustomersByRoomId) {
        this.checkCustomersByRoomId = checkCustomersByRoomId;
    }

    public RoomType getRoomTypeByRoomType() {
        return roomTypeByRoomType;
    }

    public void setRoomTypeByRoomType(RoomType roomTypeByRoomType) {
        this.roomTypeByRoomType = roomTypeByRoomType;
    }

    public Collection<RoomOrder> getRoomOrdersByRoomId() {
        return roomOrdersByRoomId;
    }

    public void setRoomOrdersByRoomId(Collection<RoomOrder> roomOrdersByRoomId) {
        this.roomOrdersByRoomId = roomOrdersByRoomId;
    }
}

package cn.edu.zjut.po;

import java.util.Collection;

public class RoomType {
    private String roomType;
    private Integer checkInNum;
    private Integer roomPrice;
    private Collection<Room> roomsByRoomType;

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getCheckInNum() {
        return checkInNum;
    }

    public void setCheckInNum(Integer checkInNum) {
        this.checkInNum = checkInNum;
    }

    public Integer getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Integer roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Collection<Room> getRoomsByRoomType() {
        return roomsByRoomType;
    }

    public void setRoomsByRoomType(Collection<Room> roomsByRoomType) {
        this.roomsByRoomType = roomsByRoomType;
    }
}

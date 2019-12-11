package cn.edu.zjut.po;

import java.util.List;

public class RoomType {
    private String roomType; // 房间类型
    private Integer checkInNum; // 最多入住人数
    private Integer roomPrice; // 房间价格
    private List<Room> rooms; // 一种房间类型对应多个房间

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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}

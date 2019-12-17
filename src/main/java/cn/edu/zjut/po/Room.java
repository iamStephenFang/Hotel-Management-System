package cn.edu.zjut.po;

import org.apache.ibatis.type.Alias;

@Alias("room")
public class Room {
    private String roomId; // 房间号
    private String roomDetail; // 房间细节
    private Boolean roomStatus; // 房间状态
    private RoomType roomType; // 一个房间对应一个房间类型

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomDetail() {
        return roomDetail;
    }

    public void setRoomDetail(String roomDetail) {
        this.roomDetail = roomDetail;
    }

    public Boolean getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}

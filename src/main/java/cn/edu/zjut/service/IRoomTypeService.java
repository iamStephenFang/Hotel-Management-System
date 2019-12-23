package cn.edu.zjut.service;

import cn.edu.zjut.po.RoomType;

public interface IRoomTypeService {
    boolean findAllRoomTypes();
    boolean findByRoomType(String roomType);
    boolean updateRoomType(RoomType roomType);
    boolean insertRoomType(RoomType roomType);
    boolean deleteRoomType(RoomType roomType);
}


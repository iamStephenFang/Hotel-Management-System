package cn.edu.zjut.service;

import cn.edu.zjut.po.Room;
import org.springframework.stereotype.Service;

@Service
public interface IRoomService {
    boolean findAllRooms();
    boolean findByRoomId(String roomID);
    boolean updateRoom(Room room);
    boolean insertRoom(Room room);
    boolean deleteRoom(Room room);
    boolean findByMultiConditions(String roomId, String type);
}

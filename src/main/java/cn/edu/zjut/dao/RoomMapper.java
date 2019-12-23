package cn.edu.zjut.dao;

import cn.edu.zjut.po.Room;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomMapper {
    /**
     * @author 方宣淼
     * @return List
     * 查询所有房间
     */
    List<Room> findAllRooms();

    /**
     * @author 方宣淼
     * @param roomID
     * @return Room
     * 通过roomID查找房间信息
     */
    Room findbyRoomID(String roomID);

    /**
     * @author 方宣淼
     * @param room 房间
     * @return int
     * 更新房间信息
     */
    int updateRoom(Room room);

    /**
     * @author 方宣淼
     * @param  room
     * @return int
     * 插入房间信息
     */
    int insertRoom(Room room);

    /**
     * @author 方宣淼
     * @param  room
     * @return int
     * 撤销房间信息
     */
    int deleteRoom(Room room);
}

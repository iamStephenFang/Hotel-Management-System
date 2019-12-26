package cn.edu.zjut.dao;

import cn.edu.zjut.po.Room;
import org.apache.ibatis.annotations.Param;
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
     * @param roomId
     * @return Room
     * 通过roomID查找房间信息
     */
    Room findByRoomId(String roomId);

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


    /**
     * @author 方宣淼
     * @param roomId 房间号
     * @param type 房间类型
     * @return List
     * 通过房间号或房间类型查询房间
     */
    List<Room> findByMultiConditions(@Param("roomId") String roomId, @Param("type") String type);
}

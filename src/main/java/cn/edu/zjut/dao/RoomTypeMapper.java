package cn.edu.zjut.dao;

import cn.edu.zjut.po.RoomType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeMapper {
    /**
     * @author 方宣淼
     * @return List
     * 查询所有房间类型
     */
    List<RoomType> findAllRoomTypes();

    /**
     * @author 方宣淼
     * @param type
     * @return RoomType
     * 通过roomType查找房间类型信息
     */
    RoomType findByRoomType(String type);

    /**
     * @author 王凌云
     * @param type 房间类型
     * @return int
     * 按房间类型查找最大入住人数
     */
    int findMaxCheckInNumByType(String type);

    /**
     * @author 方宣淼
     * @param roomType 入住房客
     * @return int
     * 更新RoomType信息，包括可入住人数与房间价格
     */
    int updateRoomType(RoomType roomType);

    /**
     * @author 方宣淼
     * @param  roomType
     * @return int
     * 插入房型信息
     */
    int insertRoomType(RoomType roomType);

    /**
     * @author 方宣淼
     * @param  roomType
     * @return int
     * 删除房型信息
     */
    int deleteRoomType(RoomType roomType);
}

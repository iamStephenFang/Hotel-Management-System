package cn.edu.zjut.dao;

import cn.edu.zjut.po.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CheckOutMapper {

    /**
     * @author 王凌云
     * @param roomId 房间号
     * @return int
     * 通过房间号更新房间状态
     */
    int updateRoomStatus(String roomId);

    /**
     * @author 王凌云
     * @param leaveTime 离开时间
     * @param roomId 房间号
     * @return int
     * 通过房间号字段和为空的离开时间字段能够唯一确定一条记录，更新这条记录的离开时间和房客居住状态
     */
    int updateLeaveTimeAndLivingStatus(@Param("leaveTime") Date leaveTime, @Param("roomId") String roomId);

    /**
     * @author 王凌云
     * @param roomId 房间号
     * @return int
     * 通过房间号字段和为空的离开时间字段，能够唯一确定一个订单号，返回这个订单号
     */
    int findOrderIdByRoomIdAndLeavingTime(String roomId);

    /**
     * @author 王凌云
     * @param orderId 订单号
     * @return int
     * 通过上面返回的订单号，查看该订单下的所有房客居住情况
     */
    int findLivingConditions(int orderId);

    /**
     * @author 王凌云
     * @param orderId 订单号
     * @return int
     * 通过上面返回的订单号，更新订单状态
     */
    int updateOrderStatus(int orderId);

    /**
     * @author 王凌云
     * @param orderId 订单号
     * @return Order
     * 通过订单号查找订单
     */
    Order findOrderById(int orderId);
}

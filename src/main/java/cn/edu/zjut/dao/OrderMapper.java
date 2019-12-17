package cn.edu.zjut.dao;

import cn.edu.zjut.po.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    /**
     * @author 王凌云
     * @return List
     * 查询所有订单
     */
    List<Order> findAllOrders();

    /**
     * @author 王凌云
     * @param id 订单号
     * @return Order
     * 通过订单号查询订单
     */
    Order findOrderById(Integer id);

    /**
     * @author 王凌云
     * @param phone 手机号
     * @return List
     * 通过手机号查询订单
     */
    List<Order> findOrdersByPhone(String phone);
}

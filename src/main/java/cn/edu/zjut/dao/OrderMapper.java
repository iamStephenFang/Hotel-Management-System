package cn.edu.zjut.dao;

import cn.edu.zjut.po.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    List<Order> findAllOrders();
    Order findOrderById(Integer id);
    List<Order> findOrdersByPhone(String phone);
}

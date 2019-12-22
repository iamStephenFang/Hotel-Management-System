package cn.edu.zjut.service;

import cn.edu.zjut.po.Order;

public interface IOrderService {
    boolean findAllOrders();
    boolean findOrderById(int orderId);
    boolean findByMultiConditions(Integer id,String phone);
    boolean updateOrder(Order order);
}

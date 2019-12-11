package cn.edu.zjut.service;

public interface IOrderService {
    boolean findAllOrders();
    boolean findOrderById(int id);
    boolean findOrdersByPhone(String phone);
}

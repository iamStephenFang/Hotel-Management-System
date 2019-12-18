package cn.edu.zjut.service;

public interface IOrderService {
    boolean findAllOrders();
    boolean findByMultiConditions(Integer id,String phone);
}

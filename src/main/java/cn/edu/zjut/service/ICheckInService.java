package cn.edu.zjut.service;

import cn.edu.zjut.po.CheckCustomer;

public interface ICheckInService {
    boolean findOrderById(int orderId);
    boolean insertCheckCustomer(CheckCustomer checkCustomer);
}

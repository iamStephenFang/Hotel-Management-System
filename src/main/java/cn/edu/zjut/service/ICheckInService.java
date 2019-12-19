package cn.edu.zjut.service;

import cn.edu.zjut.po.CheckCustomerExtendsOrder;

public interface ICheckInService {
    boolean findOrderById(int orderId);
    boolean insertCheckCustomer(CheckCustomerExtendsOrder checkCustomer);
    boolean findRoomByOrderId(int orderId);
    boolean insertMiddleRecord(CheckCustomerExtendsOrder checkCustomer);
}

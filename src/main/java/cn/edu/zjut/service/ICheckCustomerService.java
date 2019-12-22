package cn.edu.zjut.service;

import cn.edu.zjut.po.CheckCustomerExtendsOrder;

public interface ICheckCustomerService {
    boolean findCustomerByIds(int orderId, String customerId);
    boolean findAllCheckCustomers();
    boolean findAllCheckCustomersWithout();
    boolean findByMultiConditions(CheckCustomerExtendsOrder checkCustomerExtendsOrder);
    boolean updateCheckCustomer(CheckCustomerExtendsOrder checkCustomer);
}

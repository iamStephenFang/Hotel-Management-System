package cn.edu.zjut.service;

import cn.edu.zjut.po.CheckCustomerExtendsOrder;

public interface ICheckCustomerService {
    boolean findAllCheckCustomers();
    boolean findByMultiConditions(CheckCustomerExtendsOrder checkCustomerExtendsOrder);
}

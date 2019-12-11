package cn.edu.zjut.dao;

import cn.edu.zjut.po.CheckCustomer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckCustomerMapper {
    List<CheckCustomer> findAllCheckCustomers();
    List<CheckCustomer> findCheckCustomersByName(String name);
    List<CheckCustomer> findCheckCustomersById(String id);
    List<CheckCustomer> findCheckCustomersByPhone(String phone);
}

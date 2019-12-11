package cn.edu.zjut.service;

public interface ICheckCustomerService {
    boolean findAllCheckCustomers();
    boolean findCheckCustomersByName(String name);
    boolean findCheckCustomersById(String id);
    boolean findCheckCustomersByPhone(String phone);
}

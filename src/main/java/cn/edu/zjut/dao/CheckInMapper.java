package cn.edu.zjut.dao;

import cn.edu.zjut.po.CheckCustomer;
import cn.edu.zjut.po.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInMapper {
    /**
     * @author 王凌云
     * @param orderId 订单号
     * @return Order
     * 通过订单号查找订单信息
     */
    Order findOrderById(int orderId);

    /**
     * @author 王凌云
     * @param checkCustomer 入住顾客
     * @return int
     * 插入入住顾客信息
     */
    int insertCheckCustomer(CheckCustomer checkCustomer);

    /**
     * @author 王凌云
     * @param customerId 身份证号
     * @return int
     * 通过身份证号查询入住房客信息，此处主要用来判断房客是否已被记录
     */
    int findCheckCustomerById(String customerId);
}

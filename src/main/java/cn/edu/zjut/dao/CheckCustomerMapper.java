package cn.edu.zjut.dao;

import cn.edu.zjut.po.CheckCustomer;
import cn.edu.zjut.po.CheckCustomerExtendsOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckCustomerMapper {

    /**
     * @author 王凌云
     * @param orderId 订单号
     * @param customerId 身份证号
     * @return CheckCustomerExtendsOrder
     * 通过订单号和身份证号查找房客信息
     */
    CheckCustomerExtendsOrder findCustomerByIds(@Param("orderId")int orderId,@Param("customerId")String customerId);

    /**
     * @author 方宣淼
     * @return List
     * 查询所有入住房客信息
     */
    List<CheckCustomer> findAllCheckCustomersWithout();

    /**
     * @author 王凌云
     * @return List
     * 查询所有入住房客和订单的联合信息
     */
    List<CheckCustomerExtendsOrder> findAllCheckCustomers();

    /**
     * @author 王凌云
     * @param checkCustomer 入住房客
     * @return List
     * 通过多条件来查询入住房客和订单的联合信息
     */
    List<CheckCustomerExtendsOrder> findByMultiConditions(CheckCustomerExtendsOrder checkCustomer);

    /**
     * @author 王凌云
     * @param checkCustomer 入住房客
     * @return int
     * 更新入住房客信息
     */
    int updateCheckCustomer(CheckCustomer checkCustomer);
}

package cn.edu.zjut.dao;

import cn.edu.zjut.po.CheckCustomer;
import cn.edu.zjut.po.CheckCustomerExtendsOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckCustomerMapper {
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

package cn.edu.zjut.dao;

import cn.edu.zjut.po.OrderExtendsRegister;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    /**
     * @author 王凌云
     * @return List
     * 查询所有订单
     */
    List<OrderExtendsRegister> findAllOrders();

    /**
     * @author 王凌云
     * @param orderId 订单号
     * @param phone 手机号
     * @return List
     * 通过订单号或手机号查询订单
     */
    List<OrderExtendsRegister> findByMultiConditions(@Param("orderId") Integer orderId,@Param("phone") String phone);
}

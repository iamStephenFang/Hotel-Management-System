package cn.edu.zjut.action;

import cn.edu.zjut.po.Order;
import cn.edu.zjut.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class OrderAction {
    private Order order;
    private IOrderService orderService;

    public void setOrder(Order order) {
        this.order = order;
    }
    public Order getOrder() {
        return order;
    }

    @Autowired
    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }
    public IOrderService getOrderService() {
        return orderService;
    }

    /**
     * @author 王凌云
     * @return String
     * 返回所有订单信息
     */
    public String listAll(){
        if (orderService.findAllOrders()){
            return "findAllSuccess";
        }
        else {
            return "findAllFail";
        }
    }

    /**
     * @author 王凌云
     * @return String
     * 通过订单号单条件搜索订单
     */
    public String findOrderById() {
        if (orderService.findOrderById(order.getOrderId()))
            return "findOrderByIdSuccess";
        else
            return "findOrderByIdFail";
    }

    /**
     * @author 王凌云
     * @return String
     * 返回指定订单号或手机号的订单信息
     */
    public String findByMultiConditions(){
        if (orderService.findByMultiConditions(order.getOrderId(),order.getRegister().getPhone())){
            return "findByMultiConditionsSuccess";
        }
        else {
            return "findByMultiConditionsFail";
        }
    }

    /**
     * @author 王凌云
     * @return String
     * 更新订单信息
     */
    public String updateOrder() {
        if (orderService.updateOrder(order))
            return "updateOrderSuccess";
        else
            return "updateOrderFail";
    }
}

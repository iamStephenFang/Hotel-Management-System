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
     * 返回指定订单号的订单信息
     */
    public String findById(){
        if (orderService.findOrderById(order.getOrderId())){
            return "findAllSuccess";
        }
        else {
            return "findAllFail";
        }
    }

    /**
     * @author 王凌云
     * @return String
     * 返回指定手机号的订单信息
     */
    public String findByPhone(){
        if (orderService.findOrdersByPhone(order.getRegister().getPhone())){
            return "findAllSuccess";
        }
        else {
            return "findAllFail";
        }
    }
}

package cn.edu.zjut.action;

import cn.edu.zjut.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class OrderAction {
    private Integer orderId;
    private String phone;
    private IOrderService orderService;

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Integer getOrderId() {
        return orderId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
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
     * 返回指定订单号或手机号的订单信息
     */
    public String findByMultiConditions(){
        if (orderService.findByMultiConditions(orderId,phone)){
            return "findByMultiConditionsSuccess";
        }
        else {
            return "findByMultiConditionsFail";
        }
    }
}

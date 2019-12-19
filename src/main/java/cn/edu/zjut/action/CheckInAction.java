package cn.edu.zjut.action;

import cn.edu.zjut.po.CheckCustomer;
import cn.edu.zjut.service.ICheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class CheckInAction {
    private int orderId;
    private CheckCustomer checkCustomer;
    private ICheckInService checkInService = null;

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getOrderId() {
        return orderId;
    }

    public void setCheckCustomer(CheckCustomer checkCustomer) {
        this.checkCustomer = checkCustomer;
    }
    public CheckCustomer getCheckCustomer() {
        return checkCustomer;
    }

    @Autowired
    public void setCheckInService(ICheckInService checkInService) {
        this.checkInService = checkInService;
    }
    public ICheckInService getCheckInService() {
        return checkInService;
    }

    /**
     * @author 王凌云
     * @return String
     * 按订单号查询
     */
    public String findOrderById() {
        if (checkInService.findOrderById(orderId)){
            return "findOrderByIdSuccess";
        }
        else {
            return "findOrderByIdFail";
        }
    }

    /**
     * @author 王凌云
     * @return String
     * 插入入住顾客信息
     */
    public String insertCheckCustomer() {
        if (checkInService.insertCheckCustomer(checkCustomer))
            return "insertCheckCustomerSuccess";
        else
            return "insertCheckCustomerFail";
    }
}

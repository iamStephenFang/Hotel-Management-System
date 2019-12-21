package cn.edu.zjut.action;

import cn.edu.zjut.po.CheckCustomerExtendsOrder;
import cn.edu.zjut.service.ICheckInService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
@Scope("prototype")
public class CheckInAction {
    private int orderId;
    private int step;
    private CheckCustomerExtendsOrder checkCustomer;
    private ICheckInService checkInService = null;

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getOrderId() {
        return orderId;
    }

    public void setStep(int step) {
        this.step = step;
    }
    public int getStep() {
        return step;
    }

    public void setCheckCustomer(CheckCustomerExtendsOrder checkCustomer) {
        this.checkCustomer = checkCustomer;
    }
    public CheckCustomerExtendsOrder getCheckCustomer() {
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
     * 根据订单号查询空房
     */
    public String findRoomByOrderId() {
        if (checkInService.findRoomByOrderId())
            return "findRoomByOrderIdSuccess";
        else
            return "findRoomByOrderIdFail";
    }

    /**
     * @author 王凌云
     * @return String
     * 插入入住顾客信息
     * 插入订单和入住房客中间表记录
     */
    public String checkIn() {
        if (step == 3){
            if (!checkInService.findRoomByOrderId())
                return "checkInFail";
        }
        if (!checkInService.insertCheckCustomer(checkCustomer))
            return "checkInFail";
        if (checkInService.insertMiddleRecord(checkCustomer))
            return "checkInSuccess";
        else
            return "checkInFail";
    }
}

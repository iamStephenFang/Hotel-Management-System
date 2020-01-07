package cn.edu.zjut.action;

import cn.edu.zjut.po.CheckCustomerExtendsOrder;
import cn.edu.zjut.service.ICheckCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class CheckCustomerAction {
    private String orderId;
    private String customerId;
    private CheckCustomerExtendsOrder checkCustomer;
    private ICheckCustomerService checkCustomerService = null;

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getCustomerId() {
        return customerId;
    }

    public void setCheckCustomer(CheckCustomerExtendsOrder checkCustomer) {
        this.checkCustomer = checkCustomer;
    }
    public CheckCustomerExtendsOrder getCheckCustomer() {
        return checkCustomer;
    }

    @Autowired
    public void setCheckCustomerService(ICheckCustomerService checkCustomerService) {
        this.checkCustomerService = checkCustomerService;
    }
    public ICheckCustomerService getCheckCustomerService() {
        return checkCustomerService;
    }

    /**
     * @author 王凌云
     * @return String
     * 通过订单号和身份证号查找房客信息
     */
    public String findCustomerByIds() {
        if (checkCustomerService.findCustomerByIds(Integer.parseInt(orderId),customerId))
            return "findCustomerByIdsSuccess";
        else
            return "findCustomerByIdsFail";
    }

    /**
     * @author 王凌云
     * @return String
     * 查询所有入住房客
     */
    public String findAllCheckCustomers(){
        if (checkCustomerService.findAllCheckCustomers()){
            return "findAllCheckCustomersSuccess";
        }
        else {
            return "findAllCheckCustomersFail";
        }
    }

    /**
     * @author 王凌云
     * @return String
     * 按姓名 / 手机号 / 订单 / 房间号查询房客
     */
    public String findByMultiConditions(){
        if (orderId != null && !orderId.equals(""))
            checkCustomer.setOrderId(Integer.parseInt(orderId));
        if (checkCustomerService.findByMultiConditions(checkCustomer)){
            return "findByMultiConditionsSuccess";
        }
        else {
            return "findByMultiConditionsFail";
        }
    }

    /**
     * @author 王凌云
     * @return String
     * 更新入住房客信息
     */
    public String updateCheckCustomer() {
        if (checkCustomerService.updateCheckCustomer(checkCustomer)){
            return "updateCheckCustomerSuccess";
        }
        else {
            return "updateCheckCustomerFail";
        }
    }
}

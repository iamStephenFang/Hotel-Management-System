package cn.edu.zjut.action;

import cn.edu.zjut.po.CheckCustomerExtendsOrder;
import cn.edu.zjut.service.ICheckCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class CheckCustomerAction {
    private CheckCustomerExtendsOrder checkCustomer;
    private ICheckCustomerService checkCustomerService = null;

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

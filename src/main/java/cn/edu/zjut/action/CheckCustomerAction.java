package cn.edu.zjut.action;

import cn.edu.zjut.po.CheckCustomer;
import cn.edu.zjut.service.CheckCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class CheckCustomerAction {
    private CheckCustomer checkCustomer;
    private CheckCustomerService checkCustomerService = null;

    @Autowired
    public void setCheckCustomerService(CheckCustomerService checkCustomerService) {
        this.checkCustomerService = checkCustomerService;
    }
    public CheckCustomerService getCheckCustomerService() {
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
     * 按姓名查询房客
     */
    public String findCheckCustomersByName(){
        if (checkCustomerService.findCheckCustomersByName(checkCustomer.getName())){
            return "findCheckCustomersByNameSuccess";
        }
        else {
            return "findCheckCustomersByNameFail";
        }
    }

    /**
     * @author 王凌云
     * @return String
     * 按身份证号查询房客
     */
    public String findCheckCustomersById(){
        if (checkCustomerService.findCheckCustomersById(checkCustomer.getCustomerId())){
            return "findCheckCustomersByIdSuccess";
        }
        else {
            return "findCheckCustomersByIdFail";
        }
    }

    /**
     * @author 王凌云
     * @return String
     * 按手机号码查询房客
     */
    public String findCheckCustomersByPhone(){
        if (checkCustomerService.findCheckCustomersByPhone(checkCustomer.getPhone())){
            return "findCheckCustomersByPhoneSuccess";
        }
        else {
            return "findCheckCustomersByPhoneFail";
        }
    }
}

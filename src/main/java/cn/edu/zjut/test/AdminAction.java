package cn.edu.zjut.test;

import cn.edu.zjut.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class AdminAction {
    private String account;
    private String password;
    private IAdminService adminService;

    public IAdminService getAdminService() {
        return adminService;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    @Autowired
    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @author 方宣淼
     * @return String
     * 返回所有订单信息
     */
    public String listAll(){
        if (adminService.findAllAdmins()){
            return "findAllSuccess";
        }
        else {
            return "findAllFail";
        }
    }

}


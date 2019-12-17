package cn.edu.zjut.action;

import cn.edu.zjut.po.Admin;
import cn.edu.zjut.po.Waiter;
import cn.edu.zjut.service.IAdminService;
import cn.edu.zjut.service.IWaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class LoginAction {
    private String id;
    private String password;
    private int choice;
    IWaiterService waiterService;
    IAdminService adminService;

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
    public int getChoice() {
        return choice;
    }

    @Autowired
    public void setWaiterService(IWaiterService waiterService) {
        this.waiterService = waiterService;
    }
    public IWaiterService getWaiterService() {
        return waiterService;
    }

    @Autowired
    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }
    public IAdminService getAdminService() {
        return adminService;
    }

    /**
     * @author 王凌云
     * @return String
     * 服务员或管理员登录
     */
    public String login(){
        if (choice == 1){
            Waiter waiter = new Waiter();
            waiter.setWaiterId(id);
            waiter.setPassword(password);
            if (waiterService.findById(waiter)){
                return "waiterLoginSuccess";
            }
            else
                return "LoginFail";
        }
        else{
            Admin admin = new Admin();
            admin.setAdminId(id);
            admin.setPassword(password);
            if (adminService.findById(admin)){
                return "adminLoginSuccess";
            }
            else
                return "LoginFail";
        }
    }
}

package cn.edu.zjut.action;

import cn.edu.zjut.po.Admin;
import cn.edu.zjut.po.Waiter;
import cn.edu.zjut.service.IAdminService;
import cn.edu.zjut.service.IWaiterService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
@Scope("prototype")
public class InfoAction {
    private IAdminService adminService = null;
    private IWaiterService waiterService = null;
    private String account;
    private String id;
    private String oldPassword;
    private String newPassword;

    @Autowired
    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }
    public IAdminService getiAdminService() {
        return adminService;
    }

    @Autowired
    public void setWaiterService(IWaiterService waiterService) {
        this.waiterService = waiterService;
    }
    public IWaiterService getiWaiterService() {
        return waiterService;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    public String getAccount() {
        return account;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    public String getOldPassword() {
        return oldPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @author 方宣淼
     * @return String
     * 修改Admin信息
     */
    public String updateAdmin(Admin admin) {
        if (adminService.updateAdmin(admin))
            return "updateSuccess";
        else
            return "updateFail";
    }

    /**
     * @author 方宣淼
     * @return String
     * 修改Waiter信息
     */
    public String updateWaiter(Waiter waiter) {
        if (waiterService.updateWaiter(waiter))
            return "updateSuccess";
        else
            return "updateFail";
    }

    /**
     * @author 王凌云
     * @return String
     * 通过登录时存入的choice，判断修改管理员还是服务员信息
     */
    public String updateInfo() {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        int choice = (int) session.get("choice");
        if (choice == 1){
            Waiter waiter = new Waiter();
            waiter.setWaiterId(id);
            waiter.setAccount(account);
            waiter.setPassword(oldPassword);
            if (waiterService.findById(waiter).getPassword().equals(oldPassword)){
                waiter.setPassword(newPassword);
                return updateWaiter(waiter);
            }
            else
                return "updateFail";
        }
        else {
            Admin admin = new Admin();
            admin.setAdminId(id);
            admin.setAccount(account);
            admin.setPassword(oldPassword);
            if (adminService.findById(admin).getPassword().equals(oldPassword)){
                admin.setPassword(newPassword);
                return updateAdmin(admin);
            }
            else
                return "updateFail";
        }
    }
}

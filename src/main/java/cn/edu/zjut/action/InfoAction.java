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
public class InfoAction {
    private IAdminService adminService = null;
    private IWaiterService waiterService = null;
    private Admin admin;
    private Waiter waiter;

    public IAdminService getiAdminService() {
        return adminService;
    }

    public IWaiterService getiWaiterService() {
        return waiterService;
    }

    @Autowired
    public void setiAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }

    @Autowired
    public void setiWaiterService(IWaiterService waiterService) {
        this.waiterService = waiterService;
    }

    /**
     * @author 方宣淼
     * @return String
     * 修改Admin信息
     */
    public String updateAdmin() {
        if (adminService.updateAdmin(admin))
            return "updateAdminSuccess";
        else
            return "updateAdminFail";
    }

    /**
     * @author 方宣淼
     * @return String
     * 修改Waiter信息
     */
    public String updateWaiter() {
        if (waiterService.updateWaiter(waiter))
            return "updateWaiterSuccess";
        else
            return "updateWaiterFail";
    }
}

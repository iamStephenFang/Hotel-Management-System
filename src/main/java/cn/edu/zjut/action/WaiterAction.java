package cn.edu.zjut.action;

import cn.edu.zjut.po.Waiter;
import cn.edu.zjut.service.IWaiterService;
import cn.edu.zjut.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class WaiterAction {
    private Waiter waiter;
    IWaiterService waiterService;

    public Waiter getWaiter() {
        return waiter;
    }
    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    @Autowired
    public void setWaiterService(IWaiterService waiterService) {
        this.waiterService = waiterService;
    }
    public IWaiterService getWaiterService() {
        return waiterService;
    }

    /**
     * @author 王凌云
     * @return String
     * 服务员登录
     */
    public String login(){
        if (waiterService.findById(waiter)){
            return "loginSuccess";
        }
        else
            return "loginFail";
    }
}

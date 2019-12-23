package cn.edu.zjut.action;

import cn.edu.zjut.po.Waiter;
import cn.edu.zjut.service.IWaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class WaiterAction {
    private Waiter waiter;
    private IWaiterService waiterService = null;

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
    public Waiter getWaiter() {
        return waiter;
    }

    @Autowired
    public void setWaiterService(IWaiterService waiterService) {
        this.waiterService = waiterService;
    }
    public IWaiterService getWaiterService() {
        return waiterService;
    }

    /**
     * @author 方宣淼
     * @return String
     * 显示所有Waiter信息
     */
    public String findAllWaiters() {
        if (waiterService.findAllWaiters()) {
            return "findAllWaitersSuccess";
        } else {
            return "findAllWaitersFail";
        }
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

    /**
     * @author 方宣淼
     * @return String
     * 新增Waiter信息
     */
    public String insertWaiter() {
        if (waiterService.insertWaiter(waiter))
            return "insertWaiterSuccess";
        else
            return "insertWaiterFail";
    }
}

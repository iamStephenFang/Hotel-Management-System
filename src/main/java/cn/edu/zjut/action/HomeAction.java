package cn.edu.zjut.action;

import cn.edu.zjut.po.Home;
import cn.edu.zjut.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class HomeAction {
    private Home home;
    private IHomeService homeService;

    public void setHome(Home home) {
        this.home = home;
    }
    public Home getHome() {
        return home;
    }

    @Autowired
    public void setHomeService(IHomeService homeService) {
        this.homeService = homeService;
    }
    public IHomeService getHomeService() {
        return homeService;
    }

    /**
     * @author 方宣淼
     * @return String
     * 显示首页信息
     */
    public String enterIndex() {
        if (homeService.getAllNums()) {
            return "enterIndexSuccess";
        } else {
            return "enterIndexFail";
        }
    }
}

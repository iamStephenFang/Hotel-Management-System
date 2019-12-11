package cn.edu.zjut.service;

import cn.edu.zjut.dao.WaiterMapper;
import cn.edu.zjut.po.Waiter;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WaiterService implements IWaiterService {
    private Map session;
    private Map request;
    private WaiterMapper waiterMapper = null;

    @Autowired
    public void setWaiterMapper(WaiterMapper waiterMapper) {
        this.waiterMapper = waiterMapper;
    }
    public WaiterMapper getWaiterMapper() {
        return waiterMapper;
    }

    /**
     * @author 王凌云
     * @return boolean
     * 通过 waiter id 查询
     */
    @Override
    public boolean findById(Waiter waiter) {
        System.out.println("正在执行WaiterService的login方法...");
        ActionContext context = ActionContext.getContext();
        session = context.getSession();
        request = (Map<String, String>) context.get("request");
        try {
            Waiter instance = waiterMapper.findById(waiter.getWaiterId());
            if (instance == null){
                request.put("tip","用户不存在");
                System.out.println("查无此人...");
                return false;
            }
            if (instance.getPassword().equals(waiter.getPassword())) {
                session.put("waiter",instance);
                System.out.println("登录成功...");
                return true;
            }
            else {
                request.put("tip","密码错误");
                System.out.println("密码错误...");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

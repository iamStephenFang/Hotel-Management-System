package cn.edu.zjut.service;

import cn.edu.zjut.dao.WaiterMapper;
import cn.edu.zjut.po.RoomType;
import cn.edu.zjut.po.Waiter;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public Waiter findById(Waiter waiter) {
        System.out.println("正在执行WaiterService的login方法...");
        ActionContext context = ActionContext.getContext();
        session = context.getSession();
        request = (Map<String, String>) context.get("request");
        try {
            Waiter instance = waiterMapper.findById(waiter.getWaiterId());
            if (instance == null){
                request.put("tip","用户不存在");
                System.out.println("查无此人...");
                return null;
            }
            if (instance.getPassword().equals(waiter.getPassword())) {
                session.put("user",instance);
                System.out.println("查找服务员信息成功...");
                return instance;
            }
            else {
                request.put("tip","密码错误");
                System.out.println("密码错误...");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @author 方宣淼
     * @return boolean
     * 通过 waiterId 查询
     */
    @Override
    public boolean findByWaiterId(Waiter waiter) {
        System.out.println("正在执行WaiterService的findByWaiterId方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, String>) context.get("request");
        List<Waiter> waiters = new ArrayList<Waiter>();
        try {
            Waiter instance = waiterMapper.findById(waiter.getWaiterId());
            if (instance == null){
                request.put("error","服务员查询失败");
                System.out.println("查无此人...");
                return false;
            }
            else {
                request.put("waiters",instance);
                System.out.println("找到用户...");
                System.out.println(waiter);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 方宣淼
     * @return boolean
     * 查询所有Waiter账户
     */
    @Override
    public boolean findAllWaiters() {
        System.out.println("正在执行findAllWaiters方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<Waiter> waiters = new ArrayList<Waiter>();
        try {
            waiters = waiterMapper.findAllWaiters();
            if (waiters == null){
                request.put("error","服务员查询失败");
                System.out.println("查询失败...");
                return false;
            }
            else {
                request.put("waiters",waiters);
                for (Waiter waiter: waiters){
                    System.out.println(waiter);
                }
                System.out.println("查询成功...");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    /**
     * @author 方宣淼
     * @return boolean
     * 更新Waiter账户信息
     */
    @Override
    public boolean updateWaiter(Waiter waiter){
        System.out.println("正在执行updateWaiter方法...");
        try {
            int updatedColumns = waiterMapper.updateWaiter(waiter);
            if (updatedColumns == 0){
                request.put("error","服务员更新失败");
                System.out.println("更新失败...");
                return false;
            }
            else {
                System.out.println("更新成功...");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 方宣淼
     * @return boolean
     * 添加Waiter账户信息
     */
    @Override
    public boolean insertWaiter(Waiter waiter){
        System.out.println("正在执行insertWaiter方法...");
        System.out.println(waiter);
        try {
            Waiter instance = waiterMapper.findById(waiter.getWaiterId());
            if (instance == null){
                int colNum = waiterMapper.insertWaiter(waiter);
                if (colNum == 0){
                    request.put("error","新增服务员失败");
                    System.out.println("插入失败...");
                    return false;
                }
                else {
                    System.out.println("插入成功...");
                    return true;
                }
            }
            else if (instance.getPassword().equals(waiter.getPassword())) {
                request.put("error","已存在服务员信息");
                System.out.println("已存在该服务员信息...");
                return true;
            }
            else {
                request.put("error","新增服务员失败");
                System.out.println("添加服务员信息失败...");
                return false;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * @author 方宣淼
     * @return boolean
     * 删除服务员信息
     */
    @Override
    public boolean deleteWaiterById(String waiterId) {
        System.out.println("正在执行deleteWaiter方法...");
        try {
            System.out.println(waiterId);
            waiterMapper.deleteWaiter(waiterId);
                System.out.println("该服务员已删除...");
                return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}

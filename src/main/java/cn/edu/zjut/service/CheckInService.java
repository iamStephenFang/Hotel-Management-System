package cn.edu.zjut.service;

import cn.edu.zjut.dao.CheckInMapper;
import cn.edu.zjut.po.CheckCustomer;
import cn.edu.zjut.po.Order;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CheckInService implements ICheckInService {
    private Map request;
    private CheckInMapper checkInMapper = null;

    @Autowired
    public void setCheckInMapper(CheckInMapper checkInMapper) {
        this.checkInMapper = checkInMapper;
    }
    public CheckInMapper getCheckInMapper() {
        return checkInMapper;
    }

    /**
     * @author 王凌云
     * @param orderId 订单号
     * @return boolean
     * 按订单号查询
     */
    @Override
    public boolean findOrderById(int orderId) {
        System.out.println("正在执行findOrderById方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map) context.get("request");
        try {
            Order order = checkInMapper.findOrderById(orderId);
            if (order == null){
                System.out.println("查询失败...");
                return false;
            }
            else {
                System.out.println("查询成功...");
                request.put("order",order);
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 王凌云
     * @param checkCustomer 入住顾客信息
     * @return boolean
     * 插入入住顾客信息
     */
    @Override
    public boolean insertCheckCustomer(CheckCustomer checkCustomer) {
        System.out.println("正在执行insertCheckCustomer方法...");
        try {
            int flag = checkInMapper.findCheckCustomerById(checkCustomer.getCustomerId());
            if (flag == 0){
                int colNum = checkInMapper.insertCheckCustomer(checkCustomer);
                if (colNum == 0){
                    System.out.println("插入失败...");
                    return false;
                }
                else {
                    System.out.println("插入成功...");
                    return true;
                }
            }
            else if (flag == 1)
                return true;
            else {
                System.out.println("查询失败...");
                return false;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

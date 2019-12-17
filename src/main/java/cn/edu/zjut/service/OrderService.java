package cn.edu.zjut.service;

import cn.edu.zjut.dao.OrderMapper;
import cn.edu.zjut.po.CheckCustomer;
import cn.edu.zjut.po.Order;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService implements IOrderService {
    private Map request;
    private OrderMapper orderMapper = null;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }
    public OrderMapper getOrderMapper() {
        return orderMapper;
    }

    /**
     * @author 王凌云
     * @return boolean
     * 查询所有订单
     */
    @Override
    public boolean findAllOrders() {
        System.out.println("正在执行findAllOrders方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<Order> orders = new ArrayList<Order>();
        try {
            orders = orderMapper.findAllOrders();
            if (orders == null){
                System.out.println("查询失败...");
                return false;
            }
            else {
                request.put("order",orders);
                for (Order order: orders){
                    System.out.println(order);
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
     * @author 王凌云
     * @return boolean
     * 根据订单号查询所有订单
     */
    @Override
    public boolean findOrderById(int id) {
        System.out.println("正在执行findOrdersById方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, Order>)context.get("request");
        Order order = null;
        try {
            order = orderMapper.findOrderById(id);
            if (order == null){
                System.out.println("未找到订单...");
            }
            else {
                System.out.println(order);
                System.out.println("找到订单...");
            }
            request.put("order",order);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 王凌云
     * @return boolean
     * 根据手机号查询所有订单
     */
    @Override
    public boolean findOrdersByPhone(String phone) {
        System.out.println("正在执行findOrdersByPhone方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<Order> orders = new ArrayList<Order>();
        try {
            orders = orderMapper.findOrdersByPhone(phone);
            if (orders == null){
                System.out.println("未找到订单...");
            }
            else {
                for (Order order: orders){
                    System.out.println(order);
                }
                System.out.println("找到订单...");
            }
            request.put("order",orders);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

import cn.edu.zjut.dao.OrderMapper;
import cn.edu.zjut.po.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
@Rollback
public class OrderTest {
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
     * 查询所有订单
     */
    @Test
    public void findAllOrders() {
        System.out.println("正在执行findAllOrders方法...");
        List<Order> orders = new ArrayList<Order>();
        try {
            orders = orderMapper.findAllOrders();
            if (orders == null){
                System.out.println("查询失败...");
            }
            else {
                for (Order order: orders){
                    System.out.println(order);
                }
                System.out.println("查询成功...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @author 王凌云
     * 根据订单号查询所有订单
     */
    @Test
    public void findOrderById() {
        System.out.println("正在执行findOrdersById方法...");
        Order order = null;
        try {
            order = orderMapper.findOrderById(5);
            if (order == null){
                System.out.println("查询失败...");
            }
            else {
                System.out.println(order);
                System.out.println("查询成功...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @author 王凌云
     * 查询所有订单
     */
    @Test
    public void findOrdersByPhone() {
        System.out.println("正在执行findOrdersByPhone方法...");
        List<Order> orders = new ArrayList<Order>();
        try {
            orders = orderMapper.findOrdersByPhone("17857699125");
            if (orders == null){
                System.out.println("未找到订单...");
            }
            else {
                for (Order order: orders){
                    System.out.println(order);
                }
                System.out.println("找到订单...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

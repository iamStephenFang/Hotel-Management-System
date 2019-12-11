import cn.edu.zjut.dao.CheckCustomerMapper;
import cn.edu.zjut.po.CheckCustomer;
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
public class CheckCustomerTest {
    private CheckCustomerMapper checkCustomerMapper = null;

    @Autowired
    public void setCheckCustomerMapper(CheckCustomerMapper checkCustomerMapper) {
        this.checkCustomerMapper = checkCustomerMapper;
    }
    public CheckCustomerMapper getCheckCustomerMapper() {
        return checkCustomerMapper;
    }

    /**
     * @author 王凌云
     * 查询所有入住房客
     */
    @Test
    public void findAllCheckCustomer() {
        System.out.println("正在执行findAllOrders方法...");
        List<CheckCustomer> customers = new ArrayList<CheckCustomer>();
        try {
            customers = checkCustomerMapper.findAllCheckCustomers();
            if (customers == null){
                System.out.println("查询失败...");
            }
            else {
                for (CheckCustomer customer: customers){
                    System.out.println(customer);
                }
                System.out.println("查询成功...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @author 王凌云
     * 按姓名查询房客
     */
    @Test
    public void findCheckCustomersByName() {
        System.out.println("正在执行findCheckCustomerByName方法...");
        List<CheckCustomer> customers = new ArrayList<CheckCustomer>();
        try {
            customers = checkCustomerMapper.findCheckCustomersByName("小明");
            if (customers == null){
                System.out.println("查询失败...");
            }
            else {
                for (CheckCustomer customer: customers){
                    System.out.println(customer);
                }
                System.out.println("查询成功...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @author 王凌云
     * 按身份证号查询房客
     */
    @Test
    public void findCheckCustomersById() {
        System.out.println("正在执行findCheckCustomersById方法...");
        List<CheckCustomer> customers = new ArrayList<CheckCustomer>();
        try {
            customers = checkCustomerMapper.findCheckCustomersById("33028319990218****");
            if (customers == null){
                System.out.println("查询失败...");
            }
            else {
                for (CheckCustomer customer: customers){
                    System.out.println(customer);
                }
                System.out.println("查询成功...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @author 王凌云
     * 按手机号查询房客
     */
    @Test
    public void findCheckCustomersByPhone() {
        System.out.println("正在执行findCheckCustomersByPhone方法...");
        List<CheckCustomer> customers = new ArrayList<CheckCustomer>();
        try {
            customers = checkCustomerMapper.findCheckCustomersByPhone("17857699130");
            if (customers == null){
                System.out.println("查询失败...");
            }
            else {
                for (CheckCustomer customer: customers){
                    System.out.println(customer);
                }
                System.out.println("查询成功...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

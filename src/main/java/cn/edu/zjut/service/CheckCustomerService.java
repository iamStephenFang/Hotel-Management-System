package cn.edu.zjut.service;

import cn.edu.zjut.dao.CheckCustomerMapper;
import cn.edu.zjut.po.CheckCustomer;
import cn.edu.zjut.po.CheckCustomerExtendsOrder;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CheckCustomerService implements ICheckCustomerService{
    private Map request;
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
     * @param orderId 订单号
     * @param customerId 身份证号
     * @return boolean
     * 通过订单号和身份证号查找房客信息
     */
    @Override
    public boolean findCustomerByIds(int orderId,String customerId) {
        System.out.println("正在执行findCustomerByIds方法...");
        ActionContext context = ActionContext.getContext();
        Map request = (Map) context.get("request");
        try {
            System.out.println("orderId: " + orderId + ", customerId: " + customerId);
            CheckCustomerExtendsOrder customer = checkCustomerMapper.findCustomerByIds(orderId, customerId);
            if (customer == null){
                request.put("error","查找房客信息失败");
                System.out.println("查询失败...");
                return false;
            }
            else {
                System.out.println(customer);
                System.out.println("查询成功...");
                request.put("checkCustomer",customer);
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
     * 查询所有入住房客
     */
    @Override
    public boolean findAllCheckCustomers() {
        System.out.println("正在执行findAllCheckCustomers方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<CheckCustomerExtendsOrder> customers = new ArrayList<CheckCustomerExtendsOrder>();
        try {
            customers = checkCustomerMapper.findAllCheckCustomers();
            if (customers == null){
                request.put("error","查询房客信息失败");
                System.out.println("查询失败...");
                return false;
            }
            else {
                request.put("checkCustomers",customers);
                for (CheckCustomer customer: customers){
                    System.out.println(customer);
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
     * 仅查询所有入住房客
     */
    @Override
    public boolean findAllCheckCustomersWithout() {
        System.out.println("正在执行findAllCheckCustomersWithout方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<CheckCustomer> checkCustomers = new ArrayList<CheckCustomer>();
        try {
            checkCustomers = checkCustomerMapper.findAllCheckCustomersWithout();
            if (checkCustomers == null){
                request.put("error","查询入住房客信息失败");
                System.out.println("查询失败...");
                return false;
            }
            else {
                request.put("checkCustomers",checkCustomers);
                for (CheckCustomer checkCustomer: checkCustomers){
                    System.out.println(checkCustomer);
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
     * @param checkCustomer 包含订单信息和入住顾客信息
     * @return boolean
     * 按姓名 / 手机号 / 订单 / 房间号查询房客
     */
    @Override
    public boolean findByMultiConditions(CheckCustomerExtendsOrder checkCustomer) {
        System.out.println("正在执行findByMultiConditions方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<CheckCustomerExtendsOrder> customers = new ArrayList<CheckCustomerExtendsOrder>();
        try {
            customers = checkCustomerMapper.findByMultiConditions(checkCustomer);
            if (customers == null){
                request.put("error","未找到该房客");
                System.out.println("未查找到房客...");
            }
            else {
                for (CheckCustomer customer: customers){
                    System.out.println(customer);
                }
            }
            request.put("checkCustomers",customers);
            System.out.println("查询成功...");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 王凌云
     * @param checkCustomer 包含订单信息和入住顾客信息
     * @return boolean
     * 更新入住房客信息
     */
    public boolean updateCheckCustomer(CheckCustomerExtendsOrder checkCustomer) {
        System.out.println("正在执行updateCheckCustomer方法...");
        try {
            int updatedColumns = checkCustomerMapper.updateCheckCustomer(checkCustomer);
            if (updatedColumns == 0){
                request.put("error","房客信息更新失败");
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
}

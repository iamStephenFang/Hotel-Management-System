package cn.edu.zjut.service;

import cn.edu.zjut.dao.CheckCustomerMapper;
import cn.edu.zjut.po.CheckCustomer;
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
     * @return boolean
     * 查询所有入住房客
     */
    @Override
    public boolean findAllCheckCustomers() {
        System.out.println("正在执行findAllOrders方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<CheckCustomer> customers = new ArrayList<CheckCustomer>();
        try {
            customers = checkCustomerMapper.findAllCheckCustomers();
            if (customers == null){
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
     * @author 王凌云
     * @param name 姓名
     * @return boolean
     * 按姓名查询房客
     */
    @Override
    public boolean findCheckCustomersByName(String name) {
        System.out.println("正在执行findCheckCustomerByName方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<CheckCustomer> customers = new ArrayList<CheckCustomer>();
        try {
            customers = checkCustomerMapper.findCheckCustomersByName(name);
            if (customers == null){
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
     * @author 王凌云
     * @param id 身份证号
     * @return boolean
     * 按身份证号查询
     */
    @Override
    public boolean findCheckCustomersById(String id) {
        System.out.println("正在执行findCheckCustomersById方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<CheckCustomer> customers = new ArrayList<CheckCustomer>();
        try {
            customers = checkCustomerMapper.findCheckCustomersById(id);
            if (customers == null){
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
     * @author 王凌云
     * @param phone 手机号码
     * @return boolean
     * 按手机号码查询
     */
    @Override
    public boolean findCheckCustomersByPhone(String phone) {
        System.out.println("正在执行findCheckCustomersByPhone方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<CheckCustomer> customers = new ArrayList<CheckCustomer>();
        try {
            customers = checkCustomerMapper.findCheckCustomersByPhone(phone);
            if (customers == null){
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
}

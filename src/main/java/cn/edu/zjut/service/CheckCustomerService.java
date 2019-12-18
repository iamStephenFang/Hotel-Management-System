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

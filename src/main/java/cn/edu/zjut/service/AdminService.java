package cn.edu.zjut.service;

import cn.edu.zjut.dao.AdminMapper;
import cn.edu.zjut.po.Admin;
import cn.edu.zjut.po.Order;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AdminService implements IAdminService {
    private Map session;
    private Map request;
    private AdminMapper adminMapper = null;

    @Autowired
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }
    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    /**
     * @author 王凌云
     * @return boolean
     * 通过 admin id 查询
     */
    @Override
    public Admin findById(Admin admin) {
        System.out.println("正在执行AdminService的login方法...");
        ActionContext context = ActionContext.getContext();
        session = context.getSession();
        request = (Map<String, String>) context.get("request");
        try {
            Admin instance = adminMapper.findById(admin.getAdminId());
            if (instance == null){
                request.put("tip","用户不存在");
                System.out.println("查无此人...");
                return null;
            }
            if (instance.getPassword().equals(admin.getPassword())) {
                session.put("user",instance);
                System.out.println("查找管理员信息成功...");
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
     * 查询所有Admin账户
     */
    @Override
    public boolean findAllAdmins() {
        System.out.println("正在执行findAllAdmins方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<Admin> admins = new ArrayList<Admin>();
        try {
            admins = adminMapper.findAllAdmins();
            if (admins == null){
                request.put("error","查询管理员信息失败");
                System.out.println("查询失败...");
                return false;
            }
            else {
                request.put("admin",admins);
                for (Admin admin: admins){
                    System.out.println(admin);
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
     * 更新Admin账户信息
     */
    @Override
    public boolean updateAdmin(Admin admin){
        System.out.println("正在执行updateAdmin方法...");
        try {
            int updatedColumns = adminMapper.updateAdmin(admin);
            if (updatedColumns == 0){
                request.put("error","更新管理员信息失败");
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

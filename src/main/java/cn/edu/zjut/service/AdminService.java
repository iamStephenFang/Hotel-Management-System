package cn.edu.zjut.service;

import cn.edu.zjut.dao.AdminMapper;
import cn.edu.zjut.po.Admin;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean findById(Admin admin) {
        System.out.println("正在执行AdminService的login方法...");
        ActionContext context = ActionContext.getContext();
        session = context.getSession();
        request = (Map<String, String>) context.get("request");
        try {
            Admin instance = adminMapper.findById(admin.getAdminId());
            if (instance == null){
                request.put("tip","用户不存在");
                System.out.println("查无此人...");
                return false;
            }
            if (instance.getPassword().equals(admin.getPassword())) {
                session.put("admin",instance);
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

package cn.edu.zjut.service;

import cn.edu.zjut.dao.RegisterMapper;
import cn.edu.zjut.po.Register;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RegisterService implements IRegisterService{
    private Map session;
    private Map request;
    private RegisterMapper registerMapper = null;

    public RegisterMapper getRegisterMapper() {
        return registerMapper;
    }

    @Autowired
    public void setRegisterMapper(RegisterMapper registerMapper) {
        this.registerMapper = registerMapper;
    }

    /**
     * @author 方宣淼
     * @return boolean
     * 查询所有Register账户
     */
    @Override
    public boolean findAllRegisters() {
        System.out.println("正在执行findAllRegisters方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<Register> registers = new ArrayList<Register>();
        try {
            registers = registerMapper.findAllRegisters();
            if (registers == null){
                request.put("error","注册用户查询失败");
                System.out.println("查询失败...");
                return false;
            }
            else {
                request.put("registers",registers);
                for (Register register: registers){
                    System.out.println(register);
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
     * 通过Phone查询Register账户
     */
    @Override
    public boolean findByPhone(String phone) {
        System.out.println("正在执行findByPhone方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, String>) context.get("request");
        List<Register> registers = new ArrayList<Register>();
        try {
            Register register = registerMapper.findByPhone(phone);
            if (register == null){
                request.put("error","未找到注册用户");
                System.out.println("未找到注册用户...");
                return false;
            }
            else {
                System.out.println(register);
                System.out.println("找到注册用户...");
                request.put("registers",register);
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
     * 更新Register账户信息
     */
    @Override
    public boolean updateRegister(Register register){
        System.out.println("正在执行updateRegister方法...");
        try {
            int updatedColumns = registerMapper.updateRegister(register);
            if (updatedColumns == 0){
                request.put("error","更新注册用户信息失败");
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
     * 根据账户名或手机号查询所有用户
     */
    @Override
    public boolean findByMultiConditions(String account,String phone) {
        System.out.println("正在执行findByMultiConditions方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<Register> registers = new ArrayList<Register>();
        try {
            registers = registerMapper.findByMultiConditions(account,phone);
            if(registers == null){
                request.put("error","注册用户查询失败");
                System.out.println("查询失败...");
                return false;
            }
            else {
                request.put("registers",registers);
                for (Register register: registers){
                    System.out.println(register);
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

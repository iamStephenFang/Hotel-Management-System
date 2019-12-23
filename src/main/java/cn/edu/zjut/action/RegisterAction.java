package cn.edu.zjut.action;

import cn.edu.zjut.po.*;
import cn.edu.zjut.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class RegisterAction {
    private Register register;
    private IRegisterService registerService = null;

    public void setRegister(Register register) {
        this.register = register;
    }
    public Register getRegister() {
        return register;
    }

    @Autowired
    public void setRegisterService(IRegisterService registerService) {
        this.registerService = registerService;
    }
    public IRegisterService getRegisterService() {
        return registerService;
    }

    /**
     * @author 方宣淼
     * @return String
     * 显示所有Register信息
     */
    public String findAllRegisters() {
        if (registerService.findAllRegisters()) {
            return "findAllRegistersSuccess";
        } else {
            return "findAllRegsterFail";
        }
    }

    /**
     * @author 方宣淼
     * @return String
     * 修改Register信息
     */
    public String updateRegister() {
        if (registerService.updateRegister(register))
            return "updateRegisterSuccess";
        else
            return "updateRegisterFail";
    }
}

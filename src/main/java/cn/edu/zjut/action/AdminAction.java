package cn.edu.zjut.action;

import cn.edu.zjut.po.Member;
import cn.edu.zjut.po.Register;
import cn.edu.zjut.po.Waiter;
import cn.edu.zjut.service.IMemberService;
import cn.edu.zjut.service.IRegisterService;
import cn.edu.zjut.service.IWaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class AdminAction {
    private IWaiterService waiterService = null;
    private IRegisterService registerService = null;
    private IMemberService memberService = null;
    private Waiter waiter;
    private Register register;
    private Member member;

    public IWaiterService getiWaiterService() {
        return waiterService;
    }

    public IRegisterService getRegisterService() {
        return registerService;
    }

    public IMemberService getMemberService() {
        return memberService;
    }

    @Autowired
    public void setiWaiterService(IWaiterService waiterService) {
        this.waiterService = waiterService;
    }
    public void setRegisterService(IRegisterService registerService) {
        this.registerService = registerService;
    }

    public void setMemberService(IMemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * @return String
     * 显示所有Waiter信息
     * @author 方宣淼
     */
    public String findAllWaiters() {
        if (waiterService.findAllWaiters()) {
            return "findAllWaitersSuccess";
        } else {
            return "findAllWaitersFail";
        }
    }

    /**
     * @return String
     * 修改Waiter信息
     * @author 方宣淼
     */
    public String updateWaiter() {
        if (waiterService.updateWaiter(waiter))
            return "updateWaiterSuccess";
        else
            return "updateWaiterFail";
    }

    /**
     * @return String
     * 新增Waiter信息
     * @author 方宣淼
     */
    public String insertWaiter() {
        if (waiterService.insertWaiter(waiter))
            return "insertWaiterSuccess";
        else
            return "insertWaiterFail";
    }

    /**
     * @return String
     * 显示所有Register信息
     * @author 方宣淼
     */
    public String findAllRegisters() {
        if (registerService.findAllRegisters()) {
            return "findAllRegistersSuccess";
        } else {
            return "findAllRegsterFail";
        }
    }

    /**
     * @return String
     * 修改Register信息
     * @author 方宣淼
     */
    public String updateRegister() {
        if (registerService.updateRegister(register))
            return "updateRegisterSuccess";
        else
            return "updateRegisterFail";
    }

    /**
     * @return String
     * 显示所有Member信息
     * @author 方宣淼
     */
    public String findAllMembers() {
        if (memberService.findAllMembers()) {
            return "findAllMembersSuccess";
        } else {
            return "findAllMembersFail";
        }
    }

    /**
     * @return String
     * 修改Member信息
     * @author 方宣淼
     */
    public String updateMember() {
        if (memberService.updateMember(member))
            return "updateMemberSuccess";
        else
            return "updateMemberFail";
    }

    /**
     * @return String
     * 新增Member信息
     * @author 方宣淼
     */
    public String insertMember() {
        if (memberService.insertMember(member))
            return "insertMemberSuccess";
        else
            return "insertMemberFail";
    }
}

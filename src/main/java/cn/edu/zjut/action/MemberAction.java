package cn.edu.zjut.action;

import cn.edu.zjut.po.Member;
import cn.edu.zjut.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class MemberAction {
    private Member member;
    private IMemberService memberService = null;

    public void setMember(Member member) {
        this.member = member;
    }
    public Member getMember() {
        return member;
    }

    @Autowired
    public void setMemberService(IMemberService memberService) { this.memberService = memberService; }
    public IMemberService getMemberService() {
        return memberService;
    }

    /**
     * @author 方宣淼
     * @return String
     * 显示所有Member信息
     */
    public String findAllMembers() {
        if (memberService.findAllMembers()) {
            return "findAllMembersSuccess";
        } else {
            return "findAllMembersFail";
        }
    }

    /**
     * @author 方宣淼
     * @return String
     * 修改Member信息
     */
    public String updateMember() {
        if (memberService.updateMember(member))
            return "updateMemberSuccess";
        else
            return "updateMemberFail";
    }

    /**
     * @author 方宣淼
     * @return String
     * 新增Member信息
     */
    public String insertMember() {
        if (memberService.insertMember(member))
            return "insertMemberSuccess";
        else
            return "insertMemberFail";
    }

    /**
     * @author 方宣淼
     * @return String
     * 检索Member信息
     */
    public String findByLevel() {
        if (memberService.findByLevel(member.getLevel()))
            return "findByLevelSuccess";
        else
            return "findByLevelFail";
    }
}

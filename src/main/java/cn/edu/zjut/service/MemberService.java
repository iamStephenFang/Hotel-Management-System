package cn.edu.zjut.service;

import cn.edu.zjut.dao.MemberMapper;
import cn.edu.zjut.po.Member;
import cn.edu.zjut.po.Register;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MemberService implements IMemberService {
    private Map request;
    private MemberMapper memberMapper = null;

    @Autowired
    public void setMemberMapper(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public MemberMapper getMemberMapper() {
        return memberMapper;
    }

    /**
     * @author 方宣淼
     * @return boolean
     * 查询所有Member账户
     */
    @Override
    public boolean findAllMembers() {
        System.out.println("正在执行findAllMembers方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<Member> members = new ArrayList<Member>();
        try {
            members = memberMapper.findAllMembers();
            if (members == null){
                System.out.println("查询失败...");
                return false;
            }
            else {
                request.put("members",members);
                for (Member member: members){
                    System.out.println(member);
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
     * 利用Level查询成员
     */
    @Override
    public boolean findByLevel(int level) {
        System.out.println("正在执行findByLevel方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, String>) context.get("request");
        List<Member> members = new ArrayList<Member>();
        try {
            Member member = memberMapper.findByLevel(level);
            if (member == null){
                System.out.println("未找到成员信息...");
                return false;
            }
            else {
                System.out.println(member);
                System.out.println("找到注册用户...");
                request.put("members",member);
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
     * 更新Member账户信息
     */
    @Override
    public boolean updateMember(Member member){
        System.out.println("正在执行updateMember方法...");
        try {
            int updatedColumns = memberMapper.updateMember(member);
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

    /**
     * @author 方宣淼
     * @return boolean
     * 添加Member信息
     */
    @Override
    public boolean insertMember(Member member){
        System.out.println("正在执行insertMember方法...");
        System.out.println(member);
        try {
            Member instance = memberMapper.findByLevel(member.getLevel());
            if (instance == null){
                int colNum = memberMapper.insertMember(member);
                if (colNum == 0){
                    System.out.println("插入失败...");
                    return false;
                }
                else {
                    System.out.println("插入成功...");
                    return true;
                }
            }
            else {
                System.out.println("添加成员信息失败...");
                return false;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

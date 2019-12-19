package cn.edu.zjut.dao;

import cn.edu.zjut.po.Member;

import java.util.List;

public interface MemberMapper {
    /**
     * @author 方宣淼
     * @return List
     * 查询所有会员信息
     */
    List<Member> findAllMembers();
}

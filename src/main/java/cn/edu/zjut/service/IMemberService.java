package cn.edu.zjut.service;

import cn.edu.zjut.po.Member;

public interface IMemberService {
    boolean findAllMembers();
    boolean findByLevel(int level);
    boolean updateMember(Member member);
    boolean insertMember(Member member);
}

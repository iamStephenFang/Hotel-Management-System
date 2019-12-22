package cn.edu.zjut.dao;

import cn.edu.zjut.po.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberMapper {
    /**
     * @author 方宣淼
     * @return List
     * 查询所有会员信息
     */
    List<Member> findAllMembers();

    /**
     * @author 方宣淼
     * @param member 成员等级
     * @return int
     * 更新入住房客信息
     */
    int updateMember(Member member);

    /**
     * @author 方宣淼
     * @param  member
     * @return int
     * 插入成员信息
     */
    int insertMember(Member member);

    /**
     * @author 方宣淼
     * @param level
     * @return Level
     * 通过等级信息查找成员信息
     */
    Member findByLevel(int level);
}

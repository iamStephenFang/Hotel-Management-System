package cn.edu.zjut.dao;

import cn.edu.zjut.po.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    /**
     * @author 王凌云
     * @param id 管理员工号
     * @return Admin
     * 通过工号查询管理员信息
     */
    Admin findById(String id);

    /**
     * @author 方宣淼
     * @return List
     * 查询所有管理员信息
     */
    List<Admin> findAllAdmins();

    /**
     * @author 方宣淼
     * @param admin 管理员
     * @return int
     * 更新入住房客信息
     */
    int updateAdmin(Admin admin);
}

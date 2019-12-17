package cn.edu.zjut.dao;

import cn.edu.zjut.po.Admin;

public interface AdminMapper {
    /**
     * @author 王凌云
     * @param id 管理员工号
     * @return Admin
     * 通过工号查询管理员信息
     */
    Admin findById(String id);
}

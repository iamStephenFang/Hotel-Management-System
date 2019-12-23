package cn.edu.zjut.service;

import cn.edu.zjut.po.Admin;

public interface IAdminService {
    Admin findById(Admin admin);
    boolean findAllAdmins();
    boolean updateAdmin(Admin admin);
}

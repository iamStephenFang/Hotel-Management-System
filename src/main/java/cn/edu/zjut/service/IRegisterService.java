package cn.edu.zjut.service;

import cn.edu.zjut.po.Register;

public interface IRegisterService {
    boolean findAllRegisters();
    boolean findByPhone(String phone);
    boolean updateRegister(Register register);
}

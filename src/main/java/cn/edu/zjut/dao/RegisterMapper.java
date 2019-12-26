package cn.edu.zjut.dao;

import cn.edu.zjut.po.Register;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterMapper {
    /**
     * @author 方宣淼
     * @return List
     * 查询所有注册用户信息
     */
    List<Register> findAllRegisters();

    /**
     * @author 方宣淼
     * @param phone
     * @return Register
     * 通过电话号码查找注册用户信息
     */
    Register findByPhone(String phone);

    /**
     * @author 方宣淼
     * @param register 入住房客
     * @return int
     * 更新入住房客信息
     */
    int updateRegister(Register register);

    /**
     * @author 方宣淼
     * @param account 账户名
     * @param phone 手机号
     * @return List
     * 通过账户名或手机号查询用户
     */
    List<Register> findByMultiConditions(@Param("account") String account, @Param("phone") String phone);

}

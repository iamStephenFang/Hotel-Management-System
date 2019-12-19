package cn.edu.zjut.dao;

import cn.edu.zjut.po.Register;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterMapper {
    /**
     * @author 方宣淼
     * @return List
     * 查询所有入住房客和订单的联合信息
     */
    List<Register> findAllRegisters();

    /**
     * @author 方宣淼
     * @param register 入住房客
     * @return int
     * 更新入住房客信息
     */
    int updateRegister(Register register);
}

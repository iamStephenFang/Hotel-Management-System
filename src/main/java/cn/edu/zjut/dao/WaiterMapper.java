package cn.edu.zjut.dao;

import cn.edu.zjut.po.Waiter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaiterMapper {
    /**
     * @author 王凌云
     * @param id 服务员工号
     * @return Waiter
     * 通过工号查找服务员信息
     */
    Waiter findById(String id);

    /**
     * @author 方宣淼
     * @return List
     * 查询所有服务员信息
     */
    List<Waiter> findAllWaiters();
}

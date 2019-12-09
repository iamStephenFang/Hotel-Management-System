package cn.edu.zjut.dao;

import cn.edu.zjut.po.Waiter;
import org.springframework.stereotype.Repository;

@Repository
public interface WaiterMapper {
    Waiter findById(String id) throws Exception;
}

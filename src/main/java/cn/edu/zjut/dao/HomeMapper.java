package cn.edu.zjut.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface HomeMapper {
    /**
     * @author 方宣淼
     * @return int
     * 查询注册用户人数
     */
    int getRegisterNum();

    /**
     * @author 方宣淼
     * @return int
     * 查询订单个数
     */
    int getOrderNum();

    /**
     * @author 方宣淼
     * @return int
     * 查询入住人数
     */
    int getCheckCustomerNum();

    /**
     * @author 方宣淼
     * @return int
     * 查询房间数量
     */
    int getRoomNum();
}

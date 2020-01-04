package cn.edu.zjut.dao;

import cn.edu.zjut.po.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MessageMapper {
    /**
     * @author 王凌云
     * @return 消息对象List集合
     * 查询所有消息
     */
    List<Message> findAllMessage();

    /**
     * @author 王凌云
     * @param message 要插入的消息
     * 添加消息
     */
    int addMessage(Message message);

    /**
     * @author 王凌云
     * @param beginTime 消息标题
     * @param endTime 消息发送时间
     * @return 消息对象List集合
     * 按日期段查询消息
     */
    List<Message> findMessageByDate(@Param("beginTime") Date beginTime,@Param("endTime") Date endTime);

    /**
     * @author 王凌云
     * @param no 唯一的序号
     * @return 查询到的消息对象
     * 按唯一的序号查询消息
     */
    Message findMessageById(int no);

    /**
     * @author 王凌云
     * @param no 唯一的序号
     * @return 删除的行数
     * 删除消息
     */
    int deleteMessageById(int no);
}

package cn.edu.zjut.service;

import cn.edu.zjut.dao.MessageMapper;
import cn.edu.zjut.po.Message;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MessageService implements IMessageService {
    private Map request;
    private MessageMapper messageMapper;

    @Autowired
    public void setMessageMapper(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }
    public MessageMapper getMessageMapper() {
        return messageMapper;
    }

    /**
     * @author 王凌云
     * @return boolean
     * 查询所有消息
     */
    @Override
    public boolean findAllMessage() {
        System.out.println("正在执行findAllMessage方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map) context.get("request");
        List<Message> messages = new ArrayList<Message>();
        try {
            messages = messageMapper.findAllMessage();
            if (messages == null){
                System.out.println("消息查询失败...");
                return false;
            }
            else {
                System.out.println("消息查询成功...");
                for (Message message: messages) {
                    System.out.println(message);
                }
                request.put("messages",messages);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 王凌云
     * @param message 要插入的消息对象
     * @return boolean
     * 添加消息
     */
    @Override
    public boolean addMessage(Message message) {
        System.out.println("正在执行addMessage方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map) context.get("request");
        try {
            int colNum = messageMapper.addMessage(message);
            if (colNum == 0){
                System.out.println("消息插入失败...");
                return false;
            }
            else {
                System.out.println("消息插入成功...");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 王凌云
     * @param beginTime 消息标题
     * @param endTime 消息发送时间
     * @return boolean
     * 按日期段查询消息
     */
    @Override
    public boolean findMessageByDate(Date beginTime, Date endTime) {
        System.out.println("正在执行findMessageByDate方法");
        ActionContext context = ActionContext.getContext();
        request = (Map) context.get("request");
        List<Message> messages = new ArrayList<Message>();
        try {
            messages = messageMapper.findMessageByDate(beginTime,endTime);
            for (Message message: messages){
                System.out.println(message);
            }
            request.put("messages",messages);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 王凌云
     * @param no 消息序号
     * @return boolean
     * 按唯一的序号查询消息
     */
    @Override
    public boolean findMessageById(int no) {
        System.out.println("正在执行findMessageById方法");
        ActionContext context = ActionContext.getContext();
        request = (Map) context.get("request");
        try {
            Message message = messageMapper.findMessageById(no);
            if (message == null){
                System.out.println("查询失败...");
                return false;
            }
            else {
                System.out.println("查询成功...");
                System.out.println(message);
                request.put("message",message);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 王凌云
     * @param no 唯一的序号
     * @return boolean
     * 删除消息
     */
    @Override
    public boolean deleteMessageById(int no){
        System.out.println("正在执行deleteMessageById方法...");
        try {
            int colNum = messageMapper.deleteMessageById(no);
            if (colNum == 0){
                System.out.println("删除失败...");
                return false;
            }
            else {
                System.out.println("删除成功...");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

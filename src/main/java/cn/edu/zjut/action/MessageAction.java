package cn.edu.zjut.action;

import cn.edu.zjut.po.Message;
import cn.edu.zjut.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
@Scope("prototype")
public class MessageAction {
    private Message message;
    private Date beginTime;
    private Date endTime;
    private IMessageService messageService;

    public void setMessage(Message message) {
        this.message = message;
    }
    public Message getMessage() {
        return message;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
    public Date getBeginTime() {
        return beginTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public Date getEndTime() {
        return endTime;
    }

    @Autowired
    public void setMessageService(IMessageService messageService) {
        this.messageService = messageService;
    }
    public IMessageService getMessageService() {
        return messageService;
    }

    /**
     * @author 王凌云
     * @return String
     * 查询所有消息
     */
    public String findAllMessage() {
        if (messageService.findAllMessage())
            return "findAllMessageSuccess";
        else
            return "findAllMessageFail";
    }

    /**
     * @author 王凌云
     * @return String
     * 添加消息
     */
    public String addMessage() {
        message.setSendTime(new Date());
        if (messageService.addMessage(message))
            return "addMessageSuccess";
        else
            return "addMessageFail";
    }

    /**
     * @author 王凌云
     * @return String
     * 按日期段查询消息
     */
    public String findMessageByDate() {
        if (messageService.findMessageByDate(beginTime,endTime))
            return "findByMultiConditionsSuccess";
        else
            return "findByMultiConditionsFail";
    }

    /**
     * @author 王凌云
     * @return String
     * 按唯一的序号查询消息
     */
    public String findMessageById() {
        if (messageService.findMessageById(message.getNo()))
            return "findMessageByIdSuccess";
        else
            return "findMessageByIdFail";
    }

    /**
     * @author 王凌云
     * @return String
     * 删除消息
     */
    public String deleteMessageById() {
        if (messageService.deleteMessageById(message.getNo()))
            return "deleteMessageByIdSuccess";
        else
            return "deleteMessageByIdFail";
    }
}

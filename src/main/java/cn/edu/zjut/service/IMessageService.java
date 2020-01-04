package cn.edu.zjut.service;

import cn.edu.zjut.po.Message;

import java.util.Date;

public interface IMessageService {
    boolean findAllMessage();
    boolean addMessage(Message message);
    boolean findMessageByDate(Date beginTime, Date endTime);
    boolean findMessageById(int no);
    boolean deleteMessageById(int no);
}

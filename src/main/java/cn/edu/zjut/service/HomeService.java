package cn.edu.zjut.service;

import cn.edu.zjut.dao.HomeMapper;
import cn.edu.zjut.dao.MessageMapper;
import cn.edu.zjut.po.Message;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import cn.edu.zjut.po.Home;

@Service
public class HomeService implements IHomeService {
    private Map request;
    private HomeMapper homeMapper = null;
    private MessageMapper messageMapper = null;

    @Autowired
    public void setHomeMapper(HomeMapper homeMapper) {
        this.homeMapper = homeMapper;
    }
    public HomeMapper getHomeMapper() {
        return homeMapper;
    }

    @Autowired
    public void setMessageMapper(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }
    public MessageMapper getMessageMapper() {
        return messageMapper;
    }

    /**
     * @author 方宣淼
     * @return boolean
     * 获取首页所需参数
     */
    @Override
    public boolean getAllNums(){
        System.out.println("正在执行HomeService的getAllNums方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, String>) context.get("request");
        Home home = new Home();
        try{
            home.setRegisterNum(homeMapper.getRegisterNum());
            home.setOrderNum(homeMapper.getOrderNum());
            home.setCheckCustomerNum(homeMapper.getCheckCustomerNum());
            home.setRoomNum(homeMapper.getRoomNum());
            List<Message> messages = messageMapper.findAllMessage();
            for (int i = 4; i < messages.size(); i++){
                messages.remove(i);
            }
            request.put("messages",messages);
            request.put("home",home);
            System.out.println("获取首页信息成功...");
            return true;
        }catch (Exception e) {
            request.put("error","未获取到首页数据");
            e.printStackTrace();
            return false;
        }
    }

}

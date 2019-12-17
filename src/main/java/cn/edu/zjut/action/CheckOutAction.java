package cn.edu.zjut.action;

import cn.edu.zjut.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
@Scope("prototype")
public class CheckOutAction {
    private String roomId;
    private Date leaveTime;
    private CheckOutService checkOutService = null;

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public String getRoomId() {
        return roomId;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }
    public Date getLeaveTime() {
        return leaveTime;
    }

    @Autowired
    public void setCheckOutService(CheckOutService checkOutService) {
        this.checkOutService = checkOutService;
    }
    public CheckOutService getCheckOutService() {
        return checkOutService;
    }

    /**
     * @author 王凌云
     * @return String
     * 更新入住房客信息、房间状态和订单状态
     */
    public String updateLeaveTimeAndStatus() {
        if (checkOutService.updateLeaveTimeAndStatus(roomId,leaveTime))
            return "updateLeaveTimeAndStatusSuccess";
        else
            return "updateLeaveTimeAndStatusFail";
    }
}

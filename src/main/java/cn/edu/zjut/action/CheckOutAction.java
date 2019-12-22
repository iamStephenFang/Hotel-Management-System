package cn.edu.zjut.action;

import cn.edu.zjut.service.ICheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
@Scope("prototype")
public class CheckOutAction {
    private String roomId;
    private Date leaveTime;
    public int step;
    private ICheckOutService checkOutService = null;

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

    public void setStep(int step) {
        this.step = step;
    }
    public int getStep() {
        return step;
    }

    @Autowired
    public void setCheckOutService(ICheckOutService checkOutService) {
        this.checkOutService = checkOutService;
    }
    public ICheckOutService getCheckOutService() {
        return checkOutService;
    }

    /**
     * @author 王凌云
     * @return String
     * 通过房间号和离开时间为空查询订单信息
     */
    public String findOrderByRoomIdAndLeaveTime() {
        if (checkOutService.findOrderByRoomIdAndLeaveTime(roomId,leaveTime))
            return "findOrderByRoomIdAndLeaveTimeSuccess";
        else
            return "findOrderByRoomIdAndLeaveTimeFail";
    }

    /**
     * @author 王凌云
     * @return String
     * 更新入住房客信息、房间状态和订单状态
     */
    public String updateLeaveTimeAndStatus() {
        if (checkOutService.updateLeaveTimeAndStatus())
            return "updateLeaveTimeAndStatusSuccess";
        else
            return "updateLeaveTimeAndStatusFail";
    }
}

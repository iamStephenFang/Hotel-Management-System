package cn.edu.zjut.service;

import cn.edu.zjut.dao.CheckOutMapper;
import cn.edu.zjut.po.Order;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class CheckOutService implements ICheckOutService {
    private Map request;
    private CheckOutMapper checkOutMapper = null;

    @Autowired
    public void setCheckOutMapper(CheckOutMapper checkOutMapper) {
        this.checkOutMapper = checkOutMapper;
    }
    public CheckOutMapper getCheckOutMapper() {
        return checkOutMapper;
    }

    /**
     * @author 王凌云
     * @param roomId 房间号
     * @return boolean
     * 办理退房，更新入离开时间、入住状态、房间状态和订单状态
     */
    @Override
    public boolean updateLeaveTimeAndStatus(String roomId,Date leaveTime) {
        System.out.println("正在执行updateLeaveTimeAndStatus方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map) context.get("request");
        try {
            // 更新房间状态
            int colNum = checkOutMapper.updateRoomStatus(roomId);
            if (colNum == 0){
                System.out.println("房间状态更新失败...");
                return false;
            }
            System.out.println("房间状态更新成功...");

            // 更新订单状态
            int orderId = checkOutMapper.findOrderIdByRoomIdAndLeavingTime(roomId);
            int count = checkOutMapper.findLivingConditions(orderId);
            if (count == 0){
                colNum = checkOutMapper.updateOrderStatus(orderId);
                if (colNum == 0){
                    System.out.println("订单状态更新失败...");
                    return false;
                }
                System.out.println("订单状态更新成功...");
            }
            else
                System.out.println("订单：" + orderId + " 未完成，无需更新订单状态...");

            // 更新离开时间和居住状态
            colNum = checkOutMapper.updateLeaveTimeAndLivingStatus(leaveTime,roomId);
            if (colNum == 0){
                System.out.println("更新离开时间和居住状态失败...");
                return false;
            }
            System.out.println("更新离开时间和居住状态成功...");

            // 按订单号查询订单信息
            Order order = checkOutMapper.findOrderById(orderId);
            if (order == null){
                System.out.println("订单查询失败...");
                return false;
            }
            request.put("order",order);
            System.out.println("订单查询成功...");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

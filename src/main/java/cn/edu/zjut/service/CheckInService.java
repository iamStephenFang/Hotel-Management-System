package cn.edu.zjut.service;

import cn.edu.zjut.dao.CheckInMapper;
import cn.edu.zjut.dao.RoomMapper;
import cn.edu.zjut.dao.RoomTypeMapper;
import cn.edu.zjut.po.CheckCustomerExtendsOrder;
import cn.edu.zjut.po.Order;
import cn.edu.zjut.po.Room;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CheckInService implements ICheckInService {
    private Map request;
    private Map session;
    private CheckInMapper checkInMapper = null;
    private RoomMapper roomMapper = null;
    private RoomTypeMapper roomTypeMapper = null;

    @Autowired
    public void setCheckInMapper(CheckInMapper checkInMapper) {
        this.checkInMapper = checkInMapper;
    }
    public CheckInMapper getCheckInMapper() {
        return checkInMapper;
    }

    @Autowired
    public void setRoomMapper(RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }
    public RoomMapper getRoomMapper() {
        return roomMapper;
    }

    @Autowired
    public void setRoomTypeMapper(RoomTypeMapper roomTypeMapper) {
        this.roomTypeMapper = roomTypeMapper;
    }
    public RoomTypeMapper getRoomTypeMapper() {
        return roomTypeMapper;
    }

    /**
     * @author 王凌云
     * @param orderId 订单号
     * @return boolean
     * 按订单号查询
     */
    @Override
    public boolean findOrderById(int orderId) {
        System.out.println("正在执行findOrderById方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map) context.get("request");
        session = context.getSession();
        try {
            Order order = checkInMapper.findOrderById(orderId);
            if (order == null){
                request.put("error","订单查询失败");
                System.out.println("查询失败...");
                return false;
            }
            else {
                System.out.println(order);
                System.out.println("查询成功...");
                request.put("order",order);
                session.put("orderId",orderId);
                session.put("roomType",order.getRoomType());
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 王凌云
     * @param checkCustomer 入住房客信息和订单信息
     * @return boolean
     * 插入入住房客信息
     */
    @Override
    public boolean insertCheckCustomer(CheckCustomerExtendsOrder checkCustomer) {
        System.out.println("正在执行insertCheckCustomer方法...");
        System.out.println(checkCustomer);
        try {
            int flag = checkInMapper.findCheckCustomerById(checkCustomer.getCustomerId());
            if (flag == 0){
                int colNum = checkInMapper.insertCheckCustomer(checkCustomer);
                if (colNum == 0){
                    request.put("error","新增入住房客失败");
                    System.out.println("插入失败...");
                    return false;
                }
                else {
                    System.out.println("插入成功...");
                    return true;
                }
            }
            else if (flag == 1){
                request.put("error","已存在该住客信息");
                System.out.println("已存在该房客信息...");
            }
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 王凌云
     * @param checkCustomer 入住房客信息和订单信息
     * @return boolean
     * 插入订单和入住房客中间表记录
     */
    @Override
    public boolean insertMiddleRecord(CheckCustomerExtendsOrder checkCustomer) {
        System.out.println("正在执行insertMiddleRecord方法...");
        System.out.println(checkCustomer);
        ActionContext context = ActionContext.getContext();
        session = context.getSession();
        try {
            int colNum = checkInMapper.insertMiddleRecord(checkCustomer);
            if (colNum == 0) {
                request.put("error","处理入住信息失败");
                System.out.println("插入失败...");
                return false;
            }
            else {
                System.out.println("插入成功...");
            }

            int checkInNum = checkInMapper.findCheckInNumByRoomId(checkCustomer.getRoomId());
            int maxCheckInNum = roomTypeMapper.findMaxCheckInNumByType(String.valueOf(session.get("roomType")));
            session.remove("roomType");
            if (checkInNum == maxCheckInNum){
                Room room = roomMapper.findByRoomId(checkCustomer.getRoomId());
                room.setRoomStatus(false);
                colNum = roomMapper.updateRoom(room);
                if (colNum == 0){
                    System.out.println("更新房间状态失败...");
                    return false;
                }
                System.out.println("更新房间状态成功...");
                return true;
            }
            else {
                System.out.println("该房间已入住" + checkInNum + "人，" + "一共可入住" + maxCheckInNum + "人，无需更改房间状态");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 王凌云
     * @return boolean
     * 根据订单号查询空房
     */
    @Override
    public boolean findRoomByOrderId() {
        System.out.println("正在执行findRoomByOrderId方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map) context.get("request");
        session = context.getSession();
        Integer orderId = (Integer) session.get("orderId");
        if (orderId == null){
            System.out.println("会话作用域存值orderId失败...");
            return false;
        }
        try {
            List<String> rooms = checkInMapper.findRoomByOrderId(orderId);
            if (rooms == null)
                System.out.println("未查找到空房...");
            else {
                System.out.println("查找到空房...");
                for (String str: rooms){
                    System.out.println(str);
                }
            }
            request.put("rooms",rooms);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

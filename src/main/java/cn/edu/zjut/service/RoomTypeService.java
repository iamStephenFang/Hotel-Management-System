package cn.edu.zjut.service;

import cn.edu.zjut.dao.RoomTypeMapper;
import cn.edu.zjut.po.Room;
import cn.edu.zjut.po.RoomType;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RoomTypeService implements IRoomTypeService{
    private Map request;
    private RoomTypeMapper roomTypeMapper = null;


    public RoomTypeMapper getRoomTypeMapper() {
        return roomTypeMapper;
    }

    @Autowired
    public void setRoomTypeMapper(RoomTypeMapper roomTypeMapper) {
        this.roomTypeMapper = roomTypeMapper;
    }

    /**
     * @author 方宣淼
     * @return boolean
     * 查询所有房型
     */
    @Override
    public boolean findAllRoomTypes() {
        System.out.println("正在执行findAllRoomTypes方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<RoomType> roomTypes = new ArrayList<RoomType>();
        try {
            roomTypes = roomTypeMapper.findAllRoomTypes();
            if(roomTypes == null){
                System.out.println("查询失败...");
                return false;
            }
            else {
                request.put("roomTypes",roomTypes);
                for (RoomType roomType: roomTypes){
                    System.out.println("roomType");
                }
                System.out.println("查询成功...");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 方宣淼
     * @return boolean
     * 通过roomType查询房间信息
     */
    @Override
    public boolean findByRoomType(String roomType) {
        System.out.println("正在执行findByRoomType方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, String>) context.get("request");
        try {
            RoomType instance = roomTypeMapper.findByRoomType(roomType);
            if (instance == null){
                System.out.println("未找到该房型...");
                return false;
            }
            else {
                System.out.println(instance);
                System.out.println("找到该房型...");
                request.put("roomType",instance);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 方宣淼
     * @return boolean
     * 更新房型信息
     */
    @Override
    public boolean updateRoomType(RoomType roomType){
        System.out.println("正在执行updateRoomType方法...");
        try {
            int updatedColumns = roomTypeMapper.updateRoomType(roomType);
            if (updatedColumns == 0){
                System.out.println("更新失败...");
                return false;
            }
            else {
                System.out.println("更新成功...");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 方宣淼
     * @return boolean
     * 插入房型信息
     */
    @Override
    public boolean insertRoomType(RoomType roomType) {
        System.out.println("正在执行insertRoomType方法...");
        System.out.println(roomType);
        try {
            RoomType instance = roomTypeMapper.findByRoomType(roomType.getType());
            if (instance == null){
                int colNum = roomTypeMapper.insertRoomType(roomType);
                if (colNum == 0){
                    System.out.println("插入失败...");
                    return false;
                }
                else {
                    System.out.println("插入成功...");
                    return true;
                }
            }
            else if (instance.getCheckInNum().equals(roomType.getCheckInNum())) {
                System.out.println("已存在房型信息...");
                return true;
            }
            else {
                System.out.println("添加房型信息失败...");
                return false;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 方宣淼
     * @return boolean
     * 删除房型信息
     */
    @Override
    public boolean deleteRoomType(RoomType roomType) {
        System.out.println("正在执行deleteRoomType方法...");
        System.out.println(roomType);
        try {
            RoomType instance = roomTypeMapper.findByRoomType(roomType.getType());
            if (instance == null){
                System.out.println("未找到该房型...");
                return false;
            }
            else {
                System.out.println(instance);
                roomTypeMapper.deleteRoomType(instance);
                System.out.println("该房型已删除...");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

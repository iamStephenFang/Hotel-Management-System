package cn.edu.zjut.service;

import cn.edu.zjut.dao.RoomMapper;
import cn.edu.zjut.po.Room;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RoomService implements IRoomService{
    private Map request;
    private RoomMapper roomMapper = null;

    /**
     * @author 方宣淼
     * @return boolean
     * 查询所有房间
     */
    @Override
    public boolean findAllRooms() {
        System.out.println("正在执行findAllRooms方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<Room> rooms = new ArrayList<Room>();
        try {
            rooms = roomMapper.findAllRooms();
            if(rooms == null){
                System.out.println("查询失败...");
                return false;
            }
            else {
                request.put("room",rooms);
                for (Room room: rooms){
                    System.out.println("room");
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
     * 通过roomID查询房间信息
     */
    @Override
    public boolean findByRoomID(String roomID) {
        System.out.println("正在执行findByRoomID方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, String>) context.get("request");
        try {
            Room instance = roomMapper.findbyRoomID(roomID);
            if (instance == null){
                System.out.println("未找到该房间...");
                return false;
            }
            else {
                System.out.println(instance);
                System.out.println("找到该房间...");
                request.put("room",instance);
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
     * 更新房间信息
     */
    @Override
    public boolean updateRoom(Room room){
        System.out.println("正在执行updateRoom方法...");
        try {
            int updatedColumns = roomMapper.updateRoom(room);
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
     * 插入房间信息
     */
    @Override
    public boolean insertRoom(Room room) {
        System.out.println("正在执行insertRoom方法...");
        System.out.println(room);
        try {
            Room instance = roomMapper.findbyRoomID(room.getRoomId());
            if (instance == null){
                int colNum = roomMapper.insertRoom(room);
                if (colNum == 0){
                    System.out.println("插入失败...");
                    return false;
                }
                else {
                    System.out.println("插入成功...");
                    return true;
                }
            }
            else if (instance.getRoomType().equals(room.getRoomType())) {
                System.out.println("已存在房间信息...");
                return true;
            }
            else {
                System.out.println("添加房间信息失败...");
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
     * 删除房间信息
     */
    @Override
    public boolean deleteRoom(Room room) {
        System.out.println("正在执行deleteRoom方法...");
        System.out.println(room);
        try {
            Room instance = roomMapper.findbyRoomID(room.getRoomId());
            if (instance == null){
                System.out.println("未找到该房间...");
                return false;
            }
            else {
                System.out.println(instance);
                roomMapper.deleteRoom(instance);
                System.out.println("该房间已删除...");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
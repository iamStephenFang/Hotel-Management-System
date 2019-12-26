package cn.edu.zjut.action;

import cn.edu.zjut.po.Room;
import cn.edu.zjut.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class RoomAction {
    private Room room;
    private IRoomService roomService = null;

    public void setRoom(Room room) {
        this.room = room;
    }
    public Room getRoom() {
        return room;
    }

    @Autowired
    public void setRoomService(IRoomService roomService) {
        this.roomService = roomService;
    }
    public IRoomService getRoomService() {
        return roomService;
    }

    /**
     * @author 方宣淼
     * @return String
     * 显示所有Room信息
     */
    public String findAllRooms() {
        if (roomService.findAllRooms()) {
            return "findAllRoomsSuccess";
        } else {
            return "findAllRoomsFail";
        }
    }

    /**
     * @author 方宣淼
     * @return String
     * 修改Room信息
     */
    public String updateRoom() {
        if (roomService.updateRoom(room))
            return "updateRoomSuccess";
        else
            return "updateRoomFail";
    }

    /**
     * @author 方宣淼
     * @return String
     * 新增Room信息
     */
    public String insertRoom() {
        if (roomService.insertRoom(room))
            return "insertRoomSuccess";
        else
            return "insertRoomFail";
    }

    /**
     * @author 方宣淼
     * @return String
     * 删除Room信息
     */
    public String deleteRoom() {
        if (roomService.deleteRoom(room))
            return "deleteRoomSuccess";
        else
            return "deleteRoomFail";
    }

    /**
     * @author 方宣淼
     * @return String
     * 检索Room信息
     */
    public String findByRoomId() {
        if (roomService.findByRoomId(room.getRoomId()))
            return "findByRoomIdSuccess";
        else
            return "findByRoomIdFail";
    }

    /**
     * @author 方宣淼
     * @return String
     * 多条件检索Room信息
     */
    public String findByMultiConditions() {
        if (roomService.findByMultiConditions(room.getRoomId(),room.getRoomType().getType()))
            return "findByMultiConditionsSuccess";
        else
            return "findByMultiConditionsFail";
    }
}

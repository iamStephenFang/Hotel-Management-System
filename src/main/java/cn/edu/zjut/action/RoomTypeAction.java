package cn.edu.zjut.action;

import cn.edu.zjut.po.RoomType;
import cn.edu.zjut.service.IRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class RoomTypeAction {
    private RoomType roomType;
    private IRoomTypeService roomTypeService = null;

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
    public RoomType getRoomType() {
        return roomType;
    }

    @Autowired
    public void setRoomTypeService(IRoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }
    public IRoomTypeService getRoomTypeService() {
        return roomTypeService;
    }

    /**
     * @author 方宣淼
     * @return String
     * 显示所有RoomType信息
     */
    public String findAllRoomTypes() {
        if (roomTypeService.findAllRoomTypes()) {
            return "findAllRoomTypesSuccess";
        } else {
            return "findAllRoomTypesFail";
        }
    }

    /**
     * @author 方宣淼
     * @return String
     * 修改RoomType信息
     */
    public String updateRoomType() {
        if (roomTypeService.updateRoomType(roomType))
            return "updateRoomTypeSuccess";
        else
            return "updateRoomTypeFail";
    }

    /**
     * @author 方宣淼
     * @return String
     * 新增RoomType信息
     */
    public String insertRoomType() {
        if (roomTypeService.insertRoomType(roomType))
            return "insertRoomTypeSuccess";
        else
            return "insertRoomTypeFail";
    }

    /**
     * @author 方宣淼
     * @return String
     * 删除RoomType信息
     */
    public String deleteRoomType() {
        if (roomTypeService.deleteRoomType(roomType))
            return "deleteRoomTypeSuccess";
        else
            return "deleteRoomTypeFail";
    }

    /**
     * @author 方宣淼
     * @return String
     * 检索RoomType信息
     */
    public String findByRoomType() {
        if (roomTypeService.findByRoomType(roomType.getType()))
            return "findByRoomTypeSuccess";
        else
            return "findByRoomTypeFail";
    }
}

package cn.edu.zjut.action;

import cn.edu.zjut.po.*;
import cn.edu.zjut.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class AdminAction {
    private IWaiterService waiterService = null;
    private IRegisterService registerService = null;
    private IMemberService memberService = null;
    private IRoomTypeService roomTypeService = null;
    private IRoomService roomService = null;
    private Waiter waiter;
    private Register register;
    private Member member;
    private RoomType roomType;
    private Room room;

    public IWaiterService getiWaiterService() {
        return waiterService;
    }
    public IRegisterService getRegisterService() {
        return registerService;
    }
    public IMemberService getMemberService() {
        return memberService;
    }
    public IRoomService getRoomService() { return roomService; }
    public IRoomTypeService getRoomTypeService() { return roomTypeService; }

    @Autowired
    public void setiWaiterService(IWaiterService waiterService) {
        this.waiterService = waiterService;
    }
    public void setRegisterService(IRegisterService registerService) {
        this.registerService = registerService;
    }
    public void setRoomService(IRoomService roomService) { this.roomService = roomService; }
    public void setRoomTypeService(IRoomTypeService roomTypeService) { this.roomTypeService = roomTypeService; }
    public void setMemberService(IMemberService memberService) { this.memberService = memberService; }

    /**
     * @return String
     * 显示所有Waiter信息
     * @author 方宣淼
     */
    public String findAllWaiters() {
        if (waiterService.findAllWaiters()) {
            return "findAllWaitersSuccess";
        } else {
            return "findAllWaitersFail";
        }
    }

    /**
     * @return String
     * 修改Waiter信息
     * @author 方宣淼
     */
    public String updateWaiter() {
        if (waiterService.updateWaiter(waiter))
            return "updateWaiterSuccess";
        else
            return "updateWaiterFail";
    }

    /**
     * @return String
     * 新增Waiter信息
     * @author 方宣淼
     */
    public String insertWaiter() {
        if (waiterService.insertWaiter(waiter))
            return "insertWaiterSuccess";
        else
            return "insertWaiterFail";
    }

    /**
     * @return String
     * 显示所有Register信息
     * @author 方宣淼
     */
    public String findAllRegisters() {
        if (registerService.findAllRegisters()) {
            return "findAllRegistersSuccess";
        } else {
            return "findAllRegsterFail";
        }
    }

    /**
     * @return String
     * 修改Register信息
     * @author 方宣淼
     */
    public String updateRegister() {
        if (registerService.updateRegister(register))
            return "updateRegisterSuccess";
        else
            return "updateRegisterFail";
    }

    /**
     * @return String
     * 显示所有Member信息
     * @author 方宣淼
     */
    public String findAllMembers() {
        if (memberService.findAllMembers()) {
            return "findAllMembersSuccess";
        } else {
            return "findAllMembersFail";
        }
    }

    /**
     * @return String
     * 修改Member信息
     * @author 方宣淼
     */
    public String updateMember() {
        if (memberService.updateMember(member))
            return "updateMemberSuccess";
        else
            return "updateMemberFail";
    }

    /**
     * @return String
     * 新增Member信息
     * @author 方宣淼
     */
    public String insertMember() {
        if (memberService.insertMember(member))
            return "insertMemberSuccess";
        else
            return "insertMemberFail";
    }

    /**
     * @return String
     * 显示所有RoomType信息
     * @author 方宣淼
     */
    public String findAllRoomTypes() {
        if (roomTypeService.findAllRoomTypes()) {
            return "findAllRoomTypesSuccess";
        } else {
            return "findAllRoomTypesFail";
        }
    }

    /**
     * @return String
     * 修改RoomType信息
     * @author 方宣淼
     */
    public String updateRoomType() {
        if (roomTypeService.updateRoomType(roomType))
            return "updateRoomTypeSuccess";
        else
            return "updateRoomTypeFail";
    }

    /**
     * @return String
     * 新增RoomType信息
     * @author 方宣淼
     */
    public String insertRoomType() {
        if (roomTypeService.insertRoomType(roomType))
            return "insertRoomTypeSuccess";
        else
            return "insertRoomTypeFail";
    }

    /**
     * @return String
     * 删除RoomType信息
     * @author 方宣淼
     */
    public String deleteRoomType() {
        if (roomTypeService.deleteRoomType(roomType))
            return "deleteRoomTypeSuccess";
        else
            return "deleteRoomTypeFail";
    }

    /**
     * @return String
     * 检索RoomType信息
     * @author 方宣淼
     */
    public String findByRoomType() {
        if (roomTypeService.findByRoomType(roomType.getType()))
            return "findByRoomTypeSuccess";
        else
            return "findByRoomTypeFail";
    }

    /**
     * @return String
     * 显示所有Room信息
     * @author 方宣淼
     */
    public String findAllRooms() {
        if (roomService.findAllRooms()) {
            return "findAllRoomsSuccess";
        } else {
            return "findAllRoomsFail";
        }
    }

    /**
     * @return String
     * 修改Room信息
     * @author 方宣淼
     */
    public String updateRoom() {
        if (roomService.updateRoom(room))
            return "updateRoomSuccess";
        else
            return "updateRoomFail";
    }

    /**
     * @return String
     * 新增Room信息
     * @author 方宣淼
     */
    public String insertRoom() {
        if (roomService.insertRoom(room))
            return "insertRoomSuccess";
        else
            return "insertRoomFail";
    }

    /**
     * @return String
     * 删除Room信息
     * @author 方宣淼
     */
    public String deleteRoom() {
        if (roomService.deleteRoom(room))
            return "deleteRoomSuccess";
        else
            return "deleteRoomFail";
    }

    /**
     * @return String
     * 检索Room信息
     * @author 方宣淼
     */
    public String findByRoomID() {
        if (roomService.findByRoomID(room.getRoomId()))
            return "findByRoomIDSuccess";
        else
            return "findByRoomIDFail";
    }
}

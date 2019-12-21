package cn.edu.zjut.service;

import java.util.Date;

public interface ICheckOutService {
    boolean updateLeaveTimeAndStatus();
    boolean findOrderByRoomIdAndLeaveTime(String roomId,Date leaveTime);
}

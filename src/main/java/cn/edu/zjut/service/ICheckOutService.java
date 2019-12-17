package cn.edu.zjut.service;

import java.util.Date;

public interface ICheckOutService {
    boolean updateLeaveTimeAndStatus(String roomId, Date leaveTime);
}

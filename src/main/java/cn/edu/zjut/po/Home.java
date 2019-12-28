package cn.edu.zjut.po;

import org.apache.ibatis.type.Alias;

@Alias("home")
public class Home {
    private int registerNum;//总注册用户个数
    private int orderNum;//总订单个数
    private int checkCustomerNum;//总住客个数
    private int roomNum;//总房间个数

    public int getCheckCustomerNum() { return checkCustomerNum; }
    public int getOrderNum() {
        return orderNum;
    }
    public int getRegisterNum() {
        return registerNum;
    }
    public int getRoomNum() {
        return roomNum;
    }

    public void setCheckCustomerNum(int checkCustomerNum) { this.checkCustomerNum = checkCustomerNum; }
    public void setOrderNum(int orderNum) { this.orderNum = orderNum; }
    public void setRegisterNum(int registerNum) { this.registerNum = registerNum; }
    public void setRoomNum(int roomNum) { this.roomNum = roomNum; }
}

package cn.edu.zjut.po;

import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("checkCustomer")
public class CheckCustomer {
    private String customerId; // 身份证号
    private String name; // 姓名
    private Boolean gender; // 性别
    private String phone; // 手机号
    private List<Order> orders; // 一个入住顾客对应多个订单

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "CheckCustomer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", orders=" + orders +
                '}';
    }
}

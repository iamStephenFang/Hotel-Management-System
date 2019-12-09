package cn.edu.zjut.po;

import java.util.Collection;

public class Register {
    private String phone;
    private String account;
    private String password;
    private Byte gender;
    private String email;
    private Integer level;
    private Integer score;
    private Collection<Order> ordersByPhone;
    private Member memberByLevel;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Collection<Order> getOrdersByPhone() {
        return ordersByPhone;
    }

    public void setOrdersByPhone(Collection<Order> ordersByPhone) {
        this.ordersByPhone = ordersByPhone;
    }

    public Member getMemberByLevel() {
        return memberByLevel;
    }

    public void setMemberByLevel(Member memberByLevel) {
        this.memberByLevel = memberByLevel;
    }
}

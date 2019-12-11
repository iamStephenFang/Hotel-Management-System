package cn.edu.zjut.po;

import java.util.List;

public class Member {
    private Integer level; // 会员等级
    private Double discount; // 会员折扣
    private String memberDetail; // 会员详情
    private List<Register> registers; // 一种会员对应多个注册用户

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getMemberDetail() {
        return memberDetail;
    }

    public void setMemberDetail(String memberDetail) {
        this.memberDetail = memberDetail;
    }

    public List<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(List<Register> registers) {
        this.registers = registers;
    }
}

package cn.edu.zjut.po;

import java.util.Collection;

public class Member {
    private Integer level;
    private Double discount;
    private String memberDetail;
    private Collection<Register> registersByLevel;

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
}

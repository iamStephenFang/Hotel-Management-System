package cn.edu.zjut.po;

import org.apache.ibatis.type.Alias;

@Alias("orderExtReg")
public class OrderExtendsRegister extends Order {
    private String phone; // 手机号
    private String account; // 用户名
    private Boolean gender; // 性别
    private String email; //邮箱

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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "OrderExtendsRegister{" +
                "phone='" + phone + '\'' +
                ", account='" + account + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                "} ";
    }
}

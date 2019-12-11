package cn.edu.zjut.po;

public class Admin {
    private String adminId; // 管理员工号
    private String account; // 管理员姓名
    private String password; // 管理员密码

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
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
}

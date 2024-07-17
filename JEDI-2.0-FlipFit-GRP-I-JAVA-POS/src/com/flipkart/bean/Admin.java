package com.flipkart.bean;

public class Admin extends User {
    private String adminId;

    public Admin() {

    }

    public Admin(String userId, String userName, String email, String password) {
        super(userId, userName, email, password, Role.ADMIN);
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {

        this.adminId = adminId;
    }

}

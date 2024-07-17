package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.client.AdminFlipfitMenu;
import com.flipkart.exceptions.LoginFailedException;

import java.util.Objects;

public class AdminServiceImpl implements AdminServiceInterface {

    Admin admin = new Admin();

    @Override
    public void viewGymOwner(String gymOwnerId) {
    }

    @Override
    public void removeGymOwner(String gymOwnerId) {
    }

    @Override
    public boolean approveRequest(String requestId) {
        return false;
    }

    @Override
    public boolean cancelRequest(String requestId) {
        return false;
    }

    @Override
    public void viewPendingRequest(String requestId) {

    }

    @Override
    public boolean isUserValid(String userName, String password) {
        return userName.equals(admin.getUserName()) && password.equals(admin.getPassword());
    }

    @Override
    public boolean adminLogin(String userName, String password) {
        if (isUserValid(userName, password)) {
            System.out.println("Successfully logged in as admin");
        } else {
            new LoginFailedException("Admin Login Failed");
            return false;
        }
        return true;
    }

    @Override
    public void adminChangePassword(String userName, String old_password, String new_password) {
        if (Objects.equals(old_password, admin.getPassword())) {
            admin.setPassword(new_password);
            System.out.println("Successfully changed the password");
        } else {
            System.out.println("Entered wrong password");
        }
    }
}

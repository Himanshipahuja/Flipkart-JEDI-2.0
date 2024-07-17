package com.flipkart.client;

import com.flipkart.bean.Admin;
import com.flipkart.exceptions.LoginFailedException;

import java.util.Objects;


public class AdminFlipfitMenu {
     Admin admin = new Admin();

    public boolean isUserValid(String userName, String password) {
        if (userName.equals(admin.getUserName()) && password.equals(admin.getPassword())) {
            return true;
        }
        return false;
    }
    public boolean adminLogin(String userName, String password) {
        if (isUserValid(userName, password)) {
            System.out.println("Successfully logged in as admin");

        }
        else{
            new LoginFailedException("Admin Login Failed");
            return false;
        }
        return true;
    }

    public void adminClientMainPage() {
        System.out.println("Welcome to admin main page!!");
    }

    public void adminChangePassword(String userName,String old_password,String new_password){
        if(Objects.equals(old_password, admin.getPassword())){
            admin.setPassword(new_password);
            System.out.println("Successfully changed the password");
        }
        else{
            System.out.println("Entered wrong password");
        }
    }
}

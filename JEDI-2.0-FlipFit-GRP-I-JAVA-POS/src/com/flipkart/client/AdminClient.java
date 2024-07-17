package com.flipkart.client;

import com.flipkart.bean.Admin;
import com.flipkart.exceptions.LoginFailedException;


public class AdminClient {
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
            //adminClientMainPage();
        }
        else{
            new LoginFailedException("Admin Login Failed");
            return false;
        }
        return true;
    }
}

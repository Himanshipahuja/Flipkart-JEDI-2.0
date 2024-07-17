package com.flipkart.client;

import com.flipkart.bean.Admin;
import com.flipkart.exceptions.LoginFailedException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;


public class AdminFlipfitMenu {
    Admin admin = new Admin();

    public static Scanner scanner = new Scanner(System.in);

    public boolean isUserValid(String userName, String password) {
        if (userName.equals(admin.getUserName()) && password.equals(admin.getPassword())) {
            return true;
        }
        return false;
    }

    public boolean adminLogin(String userName, String password) {
        if (isUserValid(userName, password)) {
            System.out.println("Successfully logged in as admin");
            adminClientMainPage();

        } else {
            new LoginFailedException("Admin Login Failed");
            return false;
        }
        return true;
    }

    public void adminChangePassword(String userName, String old_password, String new_password) {
        if (Objects.equals(old_password, admin.getPassword())) {
            admin.setPassword(new_password);
            System.out.println("Successfully changed the password");
        } else {
            System.out.println("Entered wrong password");
        }
    }

    public void adminClientMainPage() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentTime.format(myFormat);
        System.out.println("WELCOME ADMIN!!\nLogin Time: " + currentTime);
        while (true) {
            System.out.println("0. View All Gym Owners\n1. View Pending GymOwner Approval Requests\n" +
                    "2. View Pending GymCenter's Approval Requests\n3. Go Back To Previous Menu");
            int pendingChoice = scanner.nextInt();
            switch (pendingChoice) {
                case 0:
                    System.out.println("All Gym Owners");
                    break;
                case 1:
                    System.out.println("Pending GymOwner Approval Requests");
                    break;
                case 2:
                    System.out.println("Pending GymCenter's Approval Requests");
                    break;
                case 3:
                    return;
            }
        }
    }
}

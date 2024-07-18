package com.flipkart.client;

import com.flipkart.business.AdminServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class AdminFlipfitMenu {

    AdminServiceImpl adminService = new AdminServiceImpl();

    public static Scanner scanner = new Scanner(System.in);

    public void adminLogin(String userName, String password) {
        if(adminService.adminLogin(userName, password)){
            adminClientMainPage();
        }
        else{
            System.out.println("Login failed, sorry bro");
        }
    }

    public void adminChangePassword(String userName, String old_password, String new_password) {
        adminService.adminChangePassword(userName, old_password, new_password);
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

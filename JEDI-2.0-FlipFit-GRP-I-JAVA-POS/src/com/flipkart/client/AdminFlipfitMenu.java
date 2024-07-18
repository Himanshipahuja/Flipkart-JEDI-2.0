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
            System.out.println("0. View All Gym Owners\n1. approve all gym centre requests\n2.approve gym centre request by Id\n" +
                    "3.approve all gym owner's requests\n 4. approve gym owner's request by Id\n3. Go Back To Previous Menu");
            int pendingChoice = scanner.nextInt();
            switch (pendingChoice) {
                case 0:
                    System.out.println("Viewing. All Gym Owners");
                    break;
                case 1:
                    System.out.println("approve all gym centre requests");
                    break;
                case 2:
                    System.out.println("approve gym centre request by Id");
                    break;
                case 3:
                    System.out.println("approve all gym owner's requests");
                    break;
                case 4:
                    System.out.println("approve gym owner's request by Id");
                    break;
                case 5:
                    return;
            }
        }
    }
}

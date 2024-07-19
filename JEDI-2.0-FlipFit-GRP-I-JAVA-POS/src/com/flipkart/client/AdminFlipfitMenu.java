package com.flipkart.client;

import com.flipkart.business.AdminServiceImpl;
import com.flipkart.business.GymOwnerServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class AdminFlipfitMenu {

    AdminServiceImpl adminService = new AdminServiceImpl();
    GymOwnerServiceImpl gymOwnerService = new GymOwnerServiceImpl();

    public static Scanner scanner = new Scanner(System.in);

    public void adminLogin(String userName, String password) {
        if(adminService.adminLogin(userName, password)){
            adminClientMainPage();
        }
        else{
            System.out.println("Login failed!!");
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

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("0. View All Gym Owners\n1. Approve all gym owners requests\n2. Approve gym owner's request by Id\n" +
                    "3. View All Gym Centers\n4. Approve all gym centre requests\n5. Approve gym centre's request by Id\n6. Go Back To Previous Menu");
            System.out.println("---------------------------------------------------------------------------");

            int pendingChoice = scanner.nextInt();
            switch (pendingChoice) {
                case 0:
//                    gymOwnerService.viewAllGymOwners();
                    adminService.viewAllGymOwners();
                    System.out.println("Viewing All Gym Owners");
                    break;
                case 1:
                    adminService.validateAllGymOwners();
                    System.out.println("All gym owner requests approved");
                    break;
                case 2:
                    System.out.println("Enter Gym Owner ID to approve");
                    String gymOwnerId = scanner.next();
                    adminService.validateGymOwnerByID(gymOwnerId, true);
                    System.out.println("Gym owner: "+ gymOwnerId + " request approved");
                    break;
                case 3:
                    adminService.viewAllGymCentres();
                    break;
                case 4:
                    adminService.validateAllGymCentres();
                    System.out.println("All gym centre requests approved");
                    break;
                case 5:
                    System.out.println("Enter Gym Center ID to approve");
                    String gymCentreId = scanner.next();
                    adminService.validateGymCentreByID(gymCentreId, 1);
                    System.out.println("Gym centre: "+ gymCentreId + " request approved");
                    break;
                case 6:
                    return;
            }
        }
    }
}

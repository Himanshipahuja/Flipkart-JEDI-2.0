package com.flipkart.client;

import com.flipkart.bean.Role;

import java.util.Scanner;

import static com.flipkart.constants.Constants.*;

public class FlipfitApplicationClient {

    public static int userId = 0;
    public static Scanner scanner = new Scanner(System.in);
    private static final AdminFlipfitMenu ADMIN_FLIPFIT_MENU = new AdminFlipfitMenu();

    private static final CustomerFlipfitMenu CUSTOMER_FLIPFIT_MENU = new CustomerFlipfitMenu();
    private static final GymOwnerFlipfitMenu GYM_OWNER_FLIPFIT_MENU = new GymOwnerFlipfitMenu();


    private static void mainPage(){
        System.out.println("1. Login\n2. Registration of the GYM Customer\n3. Registration of the GYM Owner\n4. Change Password\n5. Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                registration(Role.CUSTOMER);
                break;
            case 3:
                registration(Role.GYMOWNER);
                return;
            case 4:
                change_password();
                return;
            case 5:
                System.out.println(EXIT_MESSAGE);
                return;
            default:
                System.out.println(INVALID_CHOICE_ERROR);
                break;
        }
        mainPage();
    }

    private static void login(){
        try {
            System.out.println("Enter your Role");
            Role role = Role.valueOf(scanner.next().toUpperCase());

            System.out.println("Enter your UserName");
            String userName = scanner.next();

            System.out.println("Enter your Passkey");
            String password = scanner.next();

            switch (role){
                case ADMIN:
                    ADMIN_FLIPFIT_MENU.adminLogin(userName,password);
                    break;
                case GYMOWNER:
                    GYM_OWNER_FLIPFIT_MENU.gymOwnerLogin(userName,password);
                    break;
                case CUSTOMER:
                    CUSTOMER_FLIPFIT_MENU.customerLogin(userName,password);
                    break;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }catch (IllegalArgumentException e){
            System.out.println(INVALID_CHOICE_ERROR);
        }
    }

    private static void registration(Role role){
        try {
            switch (role){
                case ADMIN:
                    System.out.println("Admin is already registered");
                    mainPage();
                    break;
                case CUSTOMER:
                    CUSTOMER_FLIPFIT_MENU.register();
                    break;
                case GYMOWNER:
                    GYM_OWNER_FLIPFIT_MENU.register();

                    break;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }catch (IllegalArgumentException e){
            System.out.println(INVALID_CHOICE_ERROR);
        }
    }
    private static void change_password(){
        try {
            System.out.println("Enter your Role");
            Role role = Role.valueOf(scanner.next().toUpperCase());

            System.out.println("Enter your UserName");
            String userName = scanner.next();

            System.out.println("Enter your Old Passkey");
            String old_password = scanner.next();
            System.out.println("Enter your New Passkey");
            String new_password = scanner.next();

            switch (role){
                case ADMIN:
                    ADMIN_FLIPFIT_MENU.adminChangePassword(userName,old_password,new_password);
                    break;
                case GYMOWNER:
                    GYM_OWNER_FLIPFIT_MENU.gymOwnerChangePassword(userName,old_password,new_password);
                    break;
                case CUSTOMER:
                    CUSTOMER_FLIPFIT_MENU.customerChangePassword(userName,old_password,new_password);
                    break;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }catch (IllegalArgumentException e){
            System.out.println(INVALID_CHOICE_ERROR);
        }
    }

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        mainPage();
    }
}
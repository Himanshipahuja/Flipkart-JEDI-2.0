package com.flipkart.client;

import com.flipkart.bean.BookingDetails;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import com.flipkart.business.CustomerServiceImpl;
import com.flipkart.exceptions.WrongCredentialsException;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static com.flipkart.constants.Constants.INVALID_CHOICE_ERROR;
import static com.flipkart.constants.Constants.PREVIOUS_MENU_MESSAGE;


public class CustomerFlipfitMenu {
    public static Scanner scanner = new Scanner(System.in);

    CustomerServiceImpl customerService = new CustomerServiceImpl();

    public void customerLogin(String userName, String password) throws WrongCredentialsException {
        if(customerService.customerLogin(userName, password)) {
            String customerId = customerService.getCustomerIdFromNameAndPass(userName, password);
            customerClientMainPage(userName, customerId);
        }
        else{
            System.out.println("Invalid Credentials!");
        }
    }

    public void register() throws WrongCredentialsException {
        Customer customer = customerService.register();
        String customerId = customerService.getCustomerIdFromNameAndPass(customer.getUserName(),
                customer.getPassword());
        customerClientMainPage(customer.getUserName(), customerId);
    }

    private void bookSlotSubMenu(String userName){
        //Get Location for filter
        System.out.println("Provide Location to search :");
        String location = scanner.next();
        List<GymCentre> centreListByLocation = customerService.getAllGymCenterDetailsByCity(location);
        // Print All Centres
        for(GymCentre gymCentreAtLocation : centreListByLocation){
            System.out.println(" -------------------------------------------------------");
            System.out.println("The gym centre id:"+gymCentreAtLocation.getCentreId());
            System.out.println("The gym centre Name:"+gymCentreAtLocation.getCentreName());
            System.out.println("The gym amount:"+gymCentreAtLocation.getAmountPerSlot());
            System.out.println(" -------------------------------------------------------");

        }

        System.out.print("Choose a gymCentre ID to proceed:");
        String chosenGym = scanner.next();
        System.out.print("Enter the date and time you want to pick");
        //Select Date
        Timestamp sqlTimestamp = getTimestamp();
        String slotId = customerService.getSlotIdFromGymCentreAndTimestamp(chosenGym,sqlTimestamp);
        System.out.println("Slot id is as follows:" + slotId);

        Integer currBookingCount = customerService.getBookingCountFromSlotId(slotId);

        System.out.println("The no. of  bookings under my slot currently are: " + currBookingCount);

        Integer maximumBookingCapacity = customerService.getGymCentreCapacityFromCentreId(chosenGym);

        System.out.println("The maximum number of bookings in the given slot possible are : " + maximumBookingCapacity);

        if(currBookingCount < maximumBookingCapacity){
             String scheduleId = customerService.addSchedule(sqlTimestamp,slotId);
            String BookingId = customerService.addBooking(userName,scheduleId);
             System.out.println("Booking successfull!, schedule Id for my brother's booking: " + BookingId);
//            update schedule table
//            update booking table
        }
        else{
            System.out.println("Sorry brother, no slots available");
        }

    }

    private Timestamp getTimestamp(){
        //Select Date
        System.out.println("Enter date and time (yyyy-MM-dd HH:mm:ss): ");
        String userInput = scanner.nextLine();

        // Parse and format the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dateFormat.parse(userInput);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd HH:mm:ss");
            return getTimestamp();
        }

        // Convert date to SQL timestamp
        return new Timestamp(date.getTime());
    }

    public void printCustomerProfile(Customer customer) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("USER ID: "+ customer.getUserID());
        System.out.println("USER NAME: "+ customer.getUserName());
        System.out.println("EMAIL: "+  customer.getEmail());
        System.out.println("CONTACT: "+  customer.getCustomerPhone());
        System.out.println("CARD DETAILS: "+  customer.getCardDetails());
        System.out.println("---------------------------------------------------------------------------");
    }
    private void printUserPlan(String userName){
        System.out.println("Bookings : ");
//        List<UserPlan> allUserPlan= customerService.getCustomerPlan(userName);
        List<BookingDetails> bookingList = customerService.getCustomerBookings(userName);
        if (bookingList.isEmpty()) {
            System.out.println("No bookings found for user: " + userName);
            return;
        }

        // Print header
        System.out.printf("%-15s %-15s %-20s %-15s %n",  "Booking ID", "Date", "Center Name", "City");
        System.out.println("---------------------------------------------------------------");

        // Iterate over the list and print each booking
        for (BookingDetails booking : bookingList) {
            System.out.printf("%-15s %-15s %-20s %-15s %n",
                    booking.getBookingId(),
                    booking.getDate().toString(),
                    booking.getCentreName(),
                    booking.getCity());
        }
    }
    public void customerClientMainPage(String username, String customerId) {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Welcome to customer main page!!");
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Login TIME: "+currentTime);
        System.out.println("---------------------------------------------------------------------------");

        while(true) {
            System.out.println("1. View Profile \n2. Book a slot in Gym \n3. View Bookings\n4. Cancel Bookings\n5. Go Back to previous menu");
            System.out.println("---------------------------------------------------------------------------");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Customer customerProfile = customerService.viewMyProfile(customerId);
                    printCustomerProfile(customerProfile);
                    break;

                case 2:
                    System.out.println("Viewing all Available slots");
                    bookSlotSubMenu(username);
                    break;

                case 3:
                    printUserPlan(username);
                    break;

                case 4:
                    System.out.println("All bookings for cancel are shown");
                    break;

                case 5:
                    System.out.println(PREVIOUS_MENU_MESSAGE);
                    return;

                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }
    }

    public void customerChangePassword(String userName,String old_password,String new_password) throws WrongCredentialsException {
        customerService.customerChangePassword(userName, old_password, new_password);
    }

}

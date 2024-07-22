package com.flipkart.business;

public interface AdminServiceInterface {

    public boolean isUserValid(String userName, String password);
    public boolean adminLogin(String userName, String password);
    public void adminChangePassword(String userName, String old_password, String new_password);

    public void viewAllGymOwners();
    public void validateAllGymOwners();
    public void validateGymOwnerByID(String ownerId, int isApproved);

    public void viewAllGymCentres();
    public void validateAllGymCentres();
    public void validateGymCentreByID(String gymCentreId, int isApproved);
}

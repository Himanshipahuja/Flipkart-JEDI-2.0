package com.flipkart.business;

public interface AdminServiceInterface {
    public void viewGymOwner(String gymOwnerId);
    public void removeGymOwner(String gymOwnerId);
    public boolean approveRequest(String requestId);
    public boolean cancelRequest(String requestId);
    public void viewPendingRequest(String requestId);
    public boolean isUserValid(String userName, String password);
    public boolean adminLogin(String userName, String password);
    public void adminChangePassword(String userName, String old_password, String new_password);
}

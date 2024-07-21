package com.flipkart.dao;

import com.flipkart.bean.Customer;
import com.flipkart.exceptions.WrongCredentialsException;

public interface CustomerDAO {

    public Customer registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber);
    Customer getCustomerById(String userName);
    public boolean checkCustomerDetails(String username, String password);
    public String getCustomerIdFromNameAndPass(String userName, String password);
    public void changeCustomerPassword(String userName, String oldPassword, String newPassword) throws WrongCredentialsException;
}
package com.flipkart.dao;

import com.flipkart.bean.Customer;

public interface CustomerDAO {


    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber);
    Customer getCustomerById(String userName);
    public boolean checkCustomerDetails(String username, String password);
}
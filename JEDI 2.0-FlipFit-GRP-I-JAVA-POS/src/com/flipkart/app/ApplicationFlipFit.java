package com.flipkart.app;

import com.flipkart.bean.Customer;

public class ApplicationFlipFit {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setUserName("Abc");
        System.out.println(customer.getUserName());
    }
}

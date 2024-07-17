package com.flipkart.client;

import com.flipkart.bean.Customer;

public class MainApplicationClient {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setUserName("Abc");
        System.out.println(customer.getUserName());
    }
}

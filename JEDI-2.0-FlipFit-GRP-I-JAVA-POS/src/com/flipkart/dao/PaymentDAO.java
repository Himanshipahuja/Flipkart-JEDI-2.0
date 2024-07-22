package com.flipkart.dao;

    /**
     * @author JEDI-09
     * Interface for payment DAO operations
     */
public interface PaymentDAO {
    public String addPayment(String bookingId, float payment);
}

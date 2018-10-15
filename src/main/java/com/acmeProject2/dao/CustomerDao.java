package com.acmeProject2.dao;

import com.acmeProject2.model.Customer;

import java.util.List;

public interface CustomerDao
{
    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    //in the admin page we will be able to look at all customers (a list of customers)
    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);
}

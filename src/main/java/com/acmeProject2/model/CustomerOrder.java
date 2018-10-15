package com.acmeProject2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CustomerOrder implements Serializable
{
    private static final long serialVersionUID = 5393565422936275120L;


    //We use GenerationType.IDENTITY because initially when I created the table I didn't set the id as auto_increment
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "customerOrderId")

    @Id
    @GeneratedValue
    private int customerOrderId;


    //One order will be binded to one inventory
    @OneToOne
    @JoinColumn(name = "inventoryId")
    private Inventory inventory;


    //One customer is binded to one order
    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;


    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;


    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;



    //Getters and Setters
    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}

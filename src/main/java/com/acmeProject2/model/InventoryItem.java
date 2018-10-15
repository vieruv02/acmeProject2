package com.acmeProject2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class InventoryItem implements Serializable
{
    private static final long serialVersionUID = 337398733896547739L;


    //We use GenerationType.IDENTITY because initially when I created the table I didn't set the id as auto_increment
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "inventoryItemId")

    @Id
    @GeneratedValue
    private int inventoryItemId;


    //ManyToOne - means that many inventoryItems can be present in one Inventory
    @ManyToOne
    @JoinColumn(name = "inventoryId")
    @JsonIgnore
    private Inventory inventory;


    //ManyToOne - means that one product can belong to many InventoryItems
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    //number of products added to the inventory
    private int quantity;
    private double totalPrice;


    //Getters and Setters

    public int getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(int inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

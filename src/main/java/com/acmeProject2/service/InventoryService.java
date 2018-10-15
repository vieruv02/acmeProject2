package com.acmeProject2.service;

import com.acmeProject2.model.Inventory;


public interface InventoryService
{
    Inventory getInventoryById(int inventoryId);

    void update(Inventory inventory);
}

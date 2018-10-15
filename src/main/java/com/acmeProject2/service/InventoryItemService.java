package com.acmeProject2.service;

import com.acmeProject2.model.Inventory;
import com.acmeProject2.model.InventoryItem;
import org.springframework.stereotype.Service;

public interface InventoryItemService
{
    void addInventoryItem(InventoryItem inventoryItem);

    void removeInventoryItem(InventoryItem inventoryItem);

    void removeAllInventoryItems(Inventory inventory);

    InventoryItem getInventoryItemByProductId(int productId);
}

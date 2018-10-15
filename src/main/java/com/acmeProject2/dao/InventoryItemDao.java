package com.acmeProject2.dao;

import com.acmeProject2.model.Inventory;
import com.acmeProject2.model.InventoryItem;

/**
 * Created by vladvieru on 10/13/18.
 */
public interface InventoryItemDao
{
    void addInventoryItem(InventoryItem inventoryItem);

    void removeInventoryItem(InventoryItem inventoryItem);

    void removeAllInventoryItems(Inventory inventory);

    InventoryItem getInventoryItemByProductId(int productId);
}

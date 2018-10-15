package com.acmeProject2.dao;

import com.acmeProject2.model.Inventory;

/**
 * Created by vladvieru on 8/7/18.
 */
public interface InventoryDao
{
   Inventory getInventoryById(int inventoryId);

   void update(Inventory inventory);
}

package com.acmeProject2.service.impl;

import com.acmeProject2.dao.InventoryItemDao;
import com.acmeProject2.model.Inventory;
import com.acmeProject2.model.InventoryItem;
import com.acmeProject2.service.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryItemServiceImpl implements InventoryItemService
{
    @Autowired
    private InventoryItemDao inventoryItemDao;

    @Override
    public void addInventoryItem(InventoryItem inventoryItem) {
        inventoryItemDao.addInventoryItem(inventoryItem);
    }

    @Override
    public void removeInventoryItem(InventoryItem inventoryItem) {
        inventoryItemDao.removeInventoryItem(inventoryItem);
    }

    @Override
    public void removeAllInventoryItems(Inventory inventory) {
        inventoryItemDao.removeAllInventoryItems(inventory);
    }

    @Override
    public InventoryItem getInventoryItemByProductId(int productId){
        return inventoryItemDao.getInventoryItemByProductId(productId);
    }
}

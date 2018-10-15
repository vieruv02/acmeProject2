package com.acmeProject2.service.impl;

import com.acmeProject2.dao.InventoryDao;
import com.acmeProject2.model.Inventory;
import com.acmeProject2.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService
{
    @Autowired
    private InventoryDao inventoryDao;

    @Override
    public Inventory getInventoryById(int inventoryId) {
        return inventoryDao.getInventoryById(inventoryId);
    }

    @Override
    public void update(Inventory inventory) {
        inventoryDao.update(inventory);
    }
}

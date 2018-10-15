package com.acmeProject2.dao.impl;

import com.acmeProject2.dao.InventoryDao;
import com.acmeProject2.model.Inventory;
import com.acmeProject2.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class InventoryDaoImpl implements InventoryDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Inventory getInventoryById(int inventoryId) {
//        Session session = sessionFactory.getCurrentSession();
//        Inventory inventory = (Inventory)session.get(Inventory.class, inventoryId);
//        session.flush();
//
//        return inventory;

        Session session = sessionFactory.getCurrentSession();
        return (Inventory)session.get(Inventory.class, inventoryId);
    }

    @Override
    public void update(Inventory inventory) {
        int inventoryId = inventory.getInventoryId();
    }
}

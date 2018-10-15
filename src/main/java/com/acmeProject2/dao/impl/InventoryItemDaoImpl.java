package com.acmeProject2.dao.impl;

import com.acmeProject2.dao.InventoryItemDao;
import com.acmeProject2.model.Inventory;
import com.acmeProject2.model.InventoryItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class InventoryItemDaoImpl implements InventoryItemDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addInventoryItem(InventoryItem inventoryItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(inventoryItem);
        session.flush();
    }

    @Override
    public void removeInventoryItem(InventoryItem inventoryItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(inventoryItem);
        session.flush();
    }

    @Override
    public void removeAllInventoryItems(Inventory inventory) {
        List<InventoryItem> inventoryItems = inventory.getInventoryItems();

        for(InventoryItem item:inventoryItems){
            removeInventoryItem(item);
        }
    }

    @Override
    public InventoryItem getInventoryItemByProductId(int productId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from InventoryItem where productId=?");
        query.setInteger(0, productId);
        session.flush();

        return (InventoryItem)query.uniqueResult();
    }
}
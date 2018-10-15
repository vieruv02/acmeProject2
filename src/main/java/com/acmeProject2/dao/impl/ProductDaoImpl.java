package com.acmeProject2.dao.impl;

import com.acmeProject2.dao.ProductDao;
import com.acmeProject2.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//This class is USED only with database
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao
{

    //We need SessionFactory to connect with Hibernate
    @Autowired
    private SessionFactory sessionFactory;

    public Product getProductById(int id){
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product)session.get(Product.class, id);
        session.flush();

        return product;
    }

    public List<Product> getProductList(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product>productList=query.list();
        session.flush();

        return productList;
    }

    public void addProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void editProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void deleteProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }
}
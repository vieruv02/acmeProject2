package com.acmeProject2.service.impl;

import com.acmeProject2.dao.ProductDao;
import com.acmeProject2.model.Product;
import com.acmeProject2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService
{

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(int productId){
        return productDao.getProductById(productId);
    }

    @Override
    public List<Product> getProductList(){
        return productDao.getProductList();
    }

    @Override
    public void addProduct(Product product){
        productDao.addProduct(product);
    }

    @Override
    public void editProduct(Product product){
        productDao.editProduct(product);
    }

    @Override
    public void deleteProduct(Product product){
        productDao.deleteProduct(product);
    }
}
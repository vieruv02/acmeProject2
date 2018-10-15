package com.acmeProject2.dao;

import com.acmeProject2.model.Product;

import java.util.List;

/**
 * Created by vladvieru on 10/10/18.
 */
public interface ProductDao
{
    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}

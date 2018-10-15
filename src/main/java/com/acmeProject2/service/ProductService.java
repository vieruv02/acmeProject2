package com.acmeProject2.service;

import com.acmeProject2.model.Product;

import java.util.List;


public interface ProductService
{
    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}

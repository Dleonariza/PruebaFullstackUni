package com.uni.PruebaFullStackV1.Services.InterfacesImplements;

import com.uni.PruebaFullStackV1.Models.Product;

import java.util.List;

public interface IProduct {
    public Product createProduct(Product product);
    public Product updateProduct(Long id,Product product);
    public Product findProductById(Long id);
    public List<Product> allProducts();
    public String deletedProduct(Long id);
    public boolean findProductByCode(String code);
    public List<Product> findProductsByName(String productName);
    public List<Product> findProductByNameContaining(String productName);
    public List<Product> findProductsByCategory(String category);
    public List<String> findAllCategories();
}

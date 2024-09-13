package com.uni.PruebaFullStackV1.Services;

import com.uni.PruebaFullStackV1.Models.Product;
import com.uni.PruebaFullStackV1.Repositories.ProductRepository;
import com.uni.PruebaFullStackV1.Services.InterfacesImplements.IProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements IProduct {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        product.setCreated_at(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product actuallyProduct = findProductById(id);
        String name = product.getName();
        actuallyProduct.setName(name);
        BigDecimal price = product.getPrice();
        actuallyProduct.setPrice(price);
        String type = product.getType();
        actuallyProduct.setType(type);
        actuallyProduct.setUpdated_at(LocalDateTime.now());
        return productRepository.save(actuallyProduct);
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.getReferenceById(id);
    }

    @Override
    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    @Override
    public String deletedProduct(Long id) {
        productRepository.deleteById(id);
        return "Deleted product";
    }

    @Override
    public boolean findProductByCode(String code) {
        return productRepository.existsProductByCode(code);
    }

    @Override
    public List<Product> findProductsByName(String productName) {
        return productRepository.findProductsByName(productName);
    }

    @Override
    public List<Product> findProductByNameContaining(String productName) {
        return productRepository.findProductByNameContaining(productName);
    }

    @Override
    public List<Product> findProductsByCategory(String category) {
        return productRepository.findProductsByType(category);
    }

    @Override
    public List<String> findAllCategories() {
        return productRepository.allTypes();
    }
}

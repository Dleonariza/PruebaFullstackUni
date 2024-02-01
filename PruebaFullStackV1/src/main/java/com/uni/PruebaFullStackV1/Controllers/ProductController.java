package com.uni.PruebaFullStackV1.Controllers;

import com.uni.PruebaFullStackV1.Models.Product;
import com.uni.PruebaFullStackV1.Services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@Valid @RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestParam("id") Long id, Product product){
        return productService.updateProduct(id,product);
    }

    @GetMapping("/getProductByID")
    public Product findProductById(@RequestParam("id") Long id){
        return productService.findProductById(id);
    }

    @GetMapping("/allProducts")
    public List<Product> allProducts(){
        return productService.allProducts();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam("id") Long id){
        return ResponseEntity.ok(productService.deletedProduct(id));
    }
}

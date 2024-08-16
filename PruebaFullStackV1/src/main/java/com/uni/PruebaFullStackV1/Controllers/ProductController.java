package com.uni.PruebaFullStackV1.Controllers;

import com.uni.PruebaFullStackV1.Models.Product;
import com.uni.PruebaFullStackV1.Models.UserEntity;
import com.uni.PruebaFullStackV1.Services.ProductService;
import com.uni.PruebaFullStackV1.Services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product){
        try {
            if (!productService.findProductByCode(product.getCode())){
                return ResponseEntity.ok(productService.createProduct(product));
            }
            productService.createProduct(product);
            return ResponseEntity.badRequest().body(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestParam("id") Long id, Product product){
        return productService.updateProduct(id,product);
    }

    @GetMapping("/getProductByID")
    public Product findProductById(@RequestParam(name = "id") Long id){
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

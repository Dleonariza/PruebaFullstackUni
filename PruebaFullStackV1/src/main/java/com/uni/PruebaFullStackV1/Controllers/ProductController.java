package com.uni.PruebaFullStackV1.Controllers;

import com.uni.PruebaFullStackV1.Models.Product;
import com.uni.PruebaFullStackV1.Models.UserEntity;
import com.uni.PruebaFullStackV1.Services.ProductService;
import com.uni.PruebaFullStackV1.Services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
@PreAuthorize("denyAll()")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN', 'DEVELOPER')")
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
    @PreAuthorize("hasAnyRole('ADMIN', 'DEVELOPER')")
    public Product updateProduct(@RequestParam("id") Long id, Product product){
        return productService.updateProduct(id,product);
    }

    @GetMapping("/getProductByID")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Product findProductById(@RequestParam(name = "id") Long id){
        return productService.findProductById(id);
    }

    @GetMapping("/allProducts")
    @PreAuthorize("permitAll()")
    public List<Product> allProducts(){
        return productService.allProducts();
    }

    @GetMapping("/getProductByName")
    @PreAuthorize("permitAll()")
    public List<Product> getProductsByName(@RequestParam(name = "name") String name){
        return productService.findProductsByName(name);
    }

    @GetMapping("/getProductsByNameContaining")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<Product>> getProductsByNameContaining(@RequestParam(name = "name") String name){
        return new ResponseEntity<>(productService.findProductByNameContaining(name), HttpStatus.FOUND);
    }

    @GetMapping("/getProductsByType")
    @PreAuthorize("permitAll()")
    public List<Product> getProductsByType(@RequestParam(name = "type") String type){
        return productService.findProductsByCategory(type);
    }

    @GetMapping("/getAllTypes")
    @PreAuthorize("permitAll()")
    public List<String> getAllTypes(){
        return productService.findAllCategories();
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyRole('ADMIN', 'DEVELOPER')")
    public ResponseEntity<String> deleteProduct(@RequestParam("id") Long id){
        return ResponseEntity.ok(productService.deletedProduct(id));
    }
}

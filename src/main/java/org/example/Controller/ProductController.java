package org.example.Controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.example.Entity.Product;
import org.example.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/products/add-one")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/products/add-many")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productService.saveProductList(products);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/productsById/{id}")
    public Product findById(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/products/{name}")
    public Product findByName(@PathVariable("name") String name) {
        return productService.getProductByName(name);
    }

    @DeleteMapping("/products/{id}")
    public String deleteItem(@PathVariable("id") int id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/update")
    public Product editProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

}

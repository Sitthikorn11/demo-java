package com.example.demo.controller;

import com.example.demo.dto.Product;
import com.example.demo.dto.ProductRes;
import com.example.demo.dto.Student;
import com.example.demo.dto.StudentRes;
import com.example.demo.service.ProductService;
import com.example.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody Product product) {
        productService.saveProduct(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ProductRes>> getAll() {
        List<ProductRes> productResList = productService.findAll();
        return  ResponseEntity.ok(productResList);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<ProductRes> getById(@PathVariable Long id) {
        ProductRes productRes = productService.findById(id);
        return ResponseEntity.ok(productRes);
    }

}


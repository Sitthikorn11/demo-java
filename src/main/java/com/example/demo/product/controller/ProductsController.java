package com.example.demo.product.controller;

import com.example.demo.product.dto.CategoryRequest;
import com.example.demo.product.dto.ProductsRequest;
import com.example.demo.product.dto.SellProductsRequest;
import com.example.demo.product.service.CategoriesService;
import com.example.demo.product.service.ProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/create1")
    public ResponseEntity<Void> create(@RequestBody ProductsRequest productsRequest) {
        productsService.saveProducts(productsRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/read1")
    public ResponseEntity<List<ProductsRequest>> getAlL() {
        return ResponseEntity.ok(productsService.findall());
    }

    @PostMapping("/sell")
    public ResponseEntity<Void> sellproduct(@RequestBody SellProductsRequest sellProductsRequest) {
        productsService.save(sellProductsRequest);
        return ResponseEntity.ok().build();
    }

}

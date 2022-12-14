package com.safalifter.webscrapingwithjsoup.controller;

import com.safalifter.webscrapingwithjsoup.model.Product;
import com.safalifter.webscrapingwithjsoup.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> getProducts(
            @RequestParam(required = false) String modelNumber,
            @RequestParam(required = false) String search,
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 8) Pageable page) {
        return ResponseEntity.ok(productService.getProducts(modelNumber, search, page));
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.getProductsByName(name));
    }

    @GetMapping("/filter/{value}")
    public ResponseEntity<Page<Product>> getProductsByFilter(
            @PathVariable String value,
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 9) Pageable page) {
        return ResponseEntity.ok(productService.getProductsByFilter(value, page));
    }
}
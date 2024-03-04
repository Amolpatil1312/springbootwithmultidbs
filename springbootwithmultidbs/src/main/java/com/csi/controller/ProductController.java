package com.csi.controller;

import com.csi.model.Product;
import com.csi.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Product> save(@Valid @RequestBody Product product) {

        return new ResponseEntity<>(productServiceImpl.save(product), HttpStatus.CREATED);

    }

    @GetMapping("/findall")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productServiceImpl.findAll());
    }
}

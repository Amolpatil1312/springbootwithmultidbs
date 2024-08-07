package com.csi.controller;

import com.csi.model.Product;
import com.csi.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Product> save(@Valid @RequestBody Product product) {
        log.info("###########Trying to Save by Product##############");
        return new ResponseEntity<>(productServiceImpl.save(product), HttpStatus.CREATED);

    }

    @GetMapping("/findall")
    public ResponseEntity<List<Product>> findAll() {
        log.info("###########Trying to findAll##############");
        return ResponseEntity.ok(productServiceImpl.findAll());
    }

    @GetMapping("/findByProdId/{prodId}")
    public ResponseEntity<Optional<Product>> findByProdId(@PathVariable int prodId){
        log.info("###########Trying find By Id##############");
        return ResponseEntity.ok(productServiceImpl.findById(prodId));
    }
}

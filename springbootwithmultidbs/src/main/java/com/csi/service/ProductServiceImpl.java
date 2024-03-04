package com.csi.service;

import com.csi.model.Product;
import com.csi.repo.product.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepo productRepoImpl;

    public Product save(Product product) {
        return productRepoImpl.save(product);
    }

    public Optional<Product> findById(int productId) {
        return productRepoImpl.findById(productId);
    }

    public List<Product> findAll() {
        return productRepoImpl.findAll();
    }

    public Product update(Product product) {
        return productRepoImpl.save(product);
    }

    public void deleteById(int productId) {
        productRepoImpl.deleteById(productId);
    }

    public void deleteAll() {
        productRepoImpl.deleteAll();
    }
}

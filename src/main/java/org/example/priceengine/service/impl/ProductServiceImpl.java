package org.example.priceengine.service.impl;

import org.example.priceengine.entity.Product;
import org.example.priceengine.repository.ProductRepository;
import org.example.priceengine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }
}

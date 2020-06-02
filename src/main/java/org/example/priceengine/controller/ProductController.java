package org.example.priceengine.controller;

import org.example.priceengine.entity.Product;
import org.example.priceengine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;

    @GetMapping("getAll")
    @CrossOrigin
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> response = productService.getAllProducts();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

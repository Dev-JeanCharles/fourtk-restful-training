package com.academy.fourtk.treinamentoapirest.controllers;

import com.academy.fourtk.treinamentoapirest.dtos.requests.ProductRequest;
import com.academy.fourtk.treinamentoapirest.dtos.responses.ProductResponse;
import com.academy.fourtk.treinamentoapirest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService service;
    @PostMapping
    public ResponseEntity<ProductResponse> insertProduct(@Valid @RequestBody ProductRequest request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }
}
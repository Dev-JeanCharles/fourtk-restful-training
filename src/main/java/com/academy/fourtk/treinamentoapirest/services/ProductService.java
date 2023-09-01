package com.academy.fourtk.treinamentoapirest.services;

import com.academy.fourtk.treinamentoapirest.dtos.requests.ProductRequest;
import com.academy.fourtk.treinamentoapirest.dtos.responses.ProductResponse;
import com.academy.fourtk.treinamentoapirest.entities.Product;
import com.academy.fourtk.treinamentoapirest.entities.Supplier;
import com.academy.fourtk.treinamentoapirest.exceptions.ResourceNotFoundException;
import com.academy.fourtk.treinamentoapirest.repositories.ProductRepository;
import com.academy.fourtk.treinamentoapirest.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private SupplierRepository repository;

    @Autowired
    private ProductRepository productRepository;
    public ProductResponse save(ProductRequest request) {
        Optional<Supplier> possibleSupplier = repository.findById(request.getSupplierId());
        Supplier supplier = possibleSupplier.orElseThrow(() -> new ResourceNotFoundException("Resource not found by IDSupplier: " + request.getSupplierId()));
        Product savedProduct = productRepository.save(Product.convertProduct(request, supplier));
        return ProductResponse.convertResponse(savedProduct);
    }
}

package com.academy.fourtk.treinamentoapirest.services;

import com.academy.fourtk.treinamentoapirest.dtos.responses.ProductResponse;
import com.academy.fourtk.treinamentoapirest.entities.Product;
import com.academy.fourtk.treinamentoapirest.exceptions.ResourceNotFoundException;
import com.academy.fourtk.treinamentoapirest.repositories.ProductRepository;
import com.academy.fourtk.treinamentoapirest.repositories.SupplierRepository;
import com.academy.fourtk.treinamentoapirest.util.ProductCreate;
import com.academy.fourtk.treinamentoapirest.util.ProductRequestBuild;
import com.academy.fourtk.treinamentoapirest.util.ProductResponseBuild;
import com.academy.fourtk.treinamentoapirest.util.SupplierResponseBuild;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository productRepositoryMockk;

    @Mock
    private SupplierRepository supplierRepositoryMockk;

    @BeforeEach
    void setUp() {
        BDDMockito.when(productRepositoryMockk.save(ArgumentMatchers.any(Product.class)))
                .thenReturn(ProductCreate.saveProduct());

        BDDMockito.when(supplierRepositoryMockk.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(SupplierResponseBuild.saveSupplier()));
    }

    @Test
    @DisplayName("Save returns products when successfull")
    void save_ReturnsProducts_WhenSuccessFull() {

        ProductResponse productResponse = service.save(ProductRequestBuild.saveProduct());
        Assertions.assertThat(productResponse).isNotNull().isEqualTo(ProductResponseBuild.saveProduct());
    }

    @Test
    @DisplayName("Save returns products throws ResourceNotFoundException when supplier is not found")
    void save_ReturnsProducts_ResourceNotFoundException_WhenSupplierIsNotFound() {

        BDDMockito.when(productRepositoryMockk.save(ArgumentMatchers.any(Product.class)))
                .thenReturn(ProductCreate.saveProduct());

        BDDMockito.when(supplierRepositoryMockk.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(ResourceNotFoundException.class).isThrownBy(
                () -> service.save(ProductRequestBuild.saveProduct()));
    }
}

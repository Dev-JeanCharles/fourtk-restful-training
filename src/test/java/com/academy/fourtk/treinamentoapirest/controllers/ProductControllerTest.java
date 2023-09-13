package com.academy.fourtk.treinamentoapirest.controllers;

import com.academy.fourtk.treinamentoapirest.dtos.requests.ProductRequest;
import com.academy.fourtk.treinamentoapirest.dtos.responses.ProductResponse;
import com.academy.fourtk.treinamentoapirest.services.ProductService;
import com.academy.fourtk.treinamentoapirest.util.ProductRequestBuild;
import com.academy.fourtk.treinamentoapirest.util.ProductResponseBuild;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController controller;
    @Mock
    private ProductService serviceMockk;

    @BeforeEach
    void setUp() {
        BDDMockito.when(serviceMockk.save(ArgumentMatchers.any(ProductRequest.class)))
                .thenReturn(ProductResponseBuild.saveProduct());
    }

    @Test
    @DisplayName("Save returns products when successfull")
    void save_ReturnsProducts_WhenSuccessFull() {
        ProductResponse productResponse = controller.insertProduct(ProductRequestBuild.saveProduct()).getBody();
        Assertions.assertThat(productResponse).isNotNull().isNotEqualTo(ProductResponseBuild.saveProduct());
    }

}
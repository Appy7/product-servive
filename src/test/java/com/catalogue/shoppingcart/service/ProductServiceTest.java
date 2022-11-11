package com.catalogue.shoppingcart.service;

import com.catalogue.shoppingcart.entity.Product;
import com.catalogue.shoppingcart.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    private Product product1 = new Product(1, "Samsung", 10, 6.5f);
    private Product product2 = new Product(2, "Nokia", 15, 7.5f);

    List<Product> products = List.of(product1, product2);

    @Mock
    private ProductRepository productRepositoryMock;

    @InjectMocks
    private ProductService productService;

    @Test
    void getAllProducts() {
        // Arrange
        Mockito.when(productRepositoryMock.findAll()).thenReturn(products);
        // Act
        List<Product> allProducts = productService.getAllProducts();
        // Assert
        Assertions.assertNotNull(allProducts);
        Assertions.assertEquals("Samsung", allProducts.get(0).getName());
        Assertions.assertEquals("Nokia", allProducts.get(1).getName());
    }

    @Test
    void getProductById() {
        // Arrange
        Mockito.when(productRepositoryMock.findById(anyInt())).thenReturn(Optional.of(products.get(1)));
        // Act
        Product product = productService.getProductById(4663);
        // Assert
        Assertions.assertNotNull(product);
        Assertions.assertEquals("Nokia", product.getName());
    }

    @Test
    void saveProduct() {

    }

    @Test
    void deleteProductById() {

    }
}
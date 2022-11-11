package com.catalogue.shoppingcart.service;

import com.catalogue.shoppingcart.ProductNotFoundException;
import com.catalogue.shoppingcart.entity.Product;
import com.catalogue.shoppingcart.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) return product.get();
        else throw new ProductNotFoundException(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }
}

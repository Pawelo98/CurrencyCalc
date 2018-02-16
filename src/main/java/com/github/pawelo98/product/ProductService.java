package com.github.pawelo98.product;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ProductService {

    List<ProductDTO> findAll();
    ProductDTO addProduct(ProductDTO product);
    ProductDTO updateProduct(Long id, BigDecimal price);
    void deleteProduct(Long id);
    Set<ProductNameAndPrice> findAllInterface();
}

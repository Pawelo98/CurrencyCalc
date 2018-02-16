package com.github.pawelo98.product;

import com.github.pawelo98.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    Set<ProductNameAndPrice> findAllByPriceGreaterThan(BigDecimal Price);
}

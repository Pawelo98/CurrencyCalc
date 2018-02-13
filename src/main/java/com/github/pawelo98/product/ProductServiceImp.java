/*
package com.github.pawelo98.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;

import static com.github.pawelo98.product.ProductDTOMapper.*;

@Service
public class ProductServiceImp implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAll(){
        return toProductDTO(productRepository.findAll());
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());
        return toProductDTO(productRepository.save(product));
    }

    @Override
    public ProductDTO updateProduct(Long id, BigDecimal price){
        Product product = productRepository.findOne(id);
        product.setPrice(price);
        return toProductDTO(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long id){
        productRepository.delete(id);
    }
}

*/

package com.github.pawelo98.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;

import static com.github.pawelo98.product.ProductDTOMapper.*;

@Service
public class ProductServiceImp implements ProductService {

    private ProductRepository productRepository;
    private ProductDTOMapper productMapper;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository, ProductDTOMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> findAll(){
        return productMapper.toProductDTO(productRepository.findAll());
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());
        return productMapper.toProductDTO(productRepository.save(product));
    }

    @Override
    public ProductDTO updateProduct(Long id, BigDecimal price){
        Product product = productRepository.findOne(id);
        product.setPrice(price);
        return productMapper.toProductDTO(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long id){
        productRepository.delete(id);
    }
}


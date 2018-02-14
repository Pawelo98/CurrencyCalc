package com.github.pawelo98.supplier;

import com.github.pawelo98.product.Product;
import com.github.pawelo98.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.github.pawelo98.supplier.SupplierDTOMapper.toSupplierDTO;

@Service
public class SupplierServiceImp implements SupplierService{

    private SupplierRepository supplierRepository;
    private ProductRepository productRepository;

    @Autowired
    public SupplierServiceImp(SupplierRepository supplierRepository, ProductRepository productRepository){
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<SupplierDTO> findAll(){
        return toSupplierDTO(supplierRepository.findAll());
    }

    @Override
    public SupplierDTO addSupplier(String name, Long id){
        Supplier supplier = new Supplier();
        supplier.setName(name);

        Product product = productRepository.findOne(id);

        supplier.setProduct(product);
        return toSupplierDTO(supplierRepository.save(supplier));
    }

    @Override
    public SupplierDTO findOne(Long id) { return toSupplierDTO(supplierRepository.findOne(id));}

    @Override
    public List<SupplierDTO> findAllByProductName(String name){
        return toSupplierDTO(supplierRepository.findAllByProductName(name));
    }
}

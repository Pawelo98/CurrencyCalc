package com.github.pawelo98.supplier;

import java.util.List;
import java.util.Set;

public interface SupplierService {

    List<SupplierDTO> findAll();
    SupplierDTO findOne(Long id);
    SupplierDTO addSupplier(String name, Long id);
    List<SupplierDTO> findAllByProductName(String name);
}

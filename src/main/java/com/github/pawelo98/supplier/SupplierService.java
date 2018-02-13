package com.github.pawelo98.supplier;

import java.util.List;

public interface SupplierService {

    List<SupplierDTO> findAll();
    SupplierDTO findOne(Long id);
    SupplierDTO addSupplier(String name, Long id);
}

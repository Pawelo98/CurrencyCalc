package com.github.pawelo98.supplier;

import com.github.pawelo98.product.Product;
import com.github.pawelo98.product.ProductDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SupplierDTOMapper {

    public static SupplierDTO toSupplierDTO(Supplier supplier){
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setId(supplier.getId());
        supplierDTO.setName(supplier.getName());
        supplierDTO.setProductName(supplier.getProduct().getName());
        return supplierDTO;
    }

    public static List<SupplierDTO> toSupplierDTO(Collection<Supplier> suppliers){
        List<SupplierDTO> result = new ArrayList<SupplierDTO>();
        for(Supplier supplier : suppliers){
            result.add(toSupplierDTO(supplier));
        }
        return result;
    }
}

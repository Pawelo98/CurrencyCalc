package com.github.pawelo98.supplier;

import com.github.pawelo98.product.Product;
import com.github.pawelo98.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/suppliers")
public class SupplierController {

    private SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService){
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<SupplierDTO> findAllSuppliers(){
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public SupplierDTO findOneSupplier(@PathVariable Long id){
        return supplierService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> addSupplier(@RequestParam String name, @RequestParam Long id){
        SupplierDTO newSupplier = supplierService.addSupplier(name, id);
        return new ResponseEntity<>(newSupplier, HttpStatus.CREATED);
    }
}

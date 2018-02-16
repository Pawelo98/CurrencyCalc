package com.github.pawelo98.supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    //@Query("SELECT s from Supplier s JOINFETCH Product p")
    Set<Supplier> findAllByProductName(String product);
}

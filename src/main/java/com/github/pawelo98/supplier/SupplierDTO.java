package com.github.pawelo98.supplier;

import com.github.pawelo98.product.Product;

import javax.validation.constraints.Size;

public class SupplierDTO {


    private Long id;

    @Size(min=1, max=20)
    private String name;

    @Size(min=1, max=20)
    private String productName;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProductName() {
        return productName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

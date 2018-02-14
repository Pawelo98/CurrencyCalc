package com.github.pawelo98.product;

import com.github.pawelo98.common.BaseEntity;
import com.github.pawelo98.order.Order;
import com.github.pawelo98.supplier.Supplier;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product extends BaseEntity {

    @Column
    @Size(min=1, max=20)
    private String name;

    @DecimalMin("0.00")
    private BigDecimal price;

    @OneToMany(mappedBy = "product")
    private List<Supplier> suppliers;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

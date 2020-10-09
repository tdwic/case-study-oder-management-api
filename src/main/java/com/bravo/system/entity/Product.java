package com.bravo.system.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Product {

    @Id
    private String id;
    private String name;
    private String[] unit;
    private String quantity;
    private String price;
    private String supplier;
    private int status;


    public Product(String id, String name, String[] unit, String quantity, String price, String supplier, int status) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getUnit() {
        return unit;
    }

    public void setUnit(String[] unit) {
        this.unit = unit;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

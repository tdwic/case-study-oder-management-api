package com.bravo.system.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product_Order")
public class Product_OrderEntity {

    @Id
    private String id;
    private String orderID;
    private String productID;

    public Product_OrderEntity(String id, String orderID, String productID) {
        this.id = id;
        this.orderID = orderID;
        this.productID = productID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }
}

package com.bravo.system.repository;

import com.bravo.system.entity.OrderEntity;
import com.bravo.system.entity.Product_OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductOderRepository extends MongoRepository<Product_OrderEntity, String> {
    List<Product_OrderEntity> findAllByOrderID(String orderID);
}

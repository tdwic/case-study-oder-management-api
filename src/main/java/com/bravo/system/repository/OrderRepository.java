package com.bravo.system.repository;

import com.bravo.system.entity.OrderEntity;
import com.bravo.system.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {
 OrderEntity findByOrderNo(String OrderNo);

}

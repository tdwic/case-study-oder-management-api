package com.bravo.system.repository;

import com.bravo.system.entity.OrderEntity;
import com.bravo.system.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {
 OrderEntity findByOrderNo(String OrderNo);
 List<OrderEntity> findAllByOrderStatusIs(String orderStatus);
 List<OrderEntity> findAllByOrderStatusIsNot(String orderStatus);

}

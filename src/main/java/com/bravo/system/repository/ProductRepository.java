package com.bravo.system.repository;

import com.bravo.system.entity.ProductEntity;
//import com.bravo.system.entity.SeniorManagerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
    List<ProductEntity> findByOrderNo(String orderNo);
}

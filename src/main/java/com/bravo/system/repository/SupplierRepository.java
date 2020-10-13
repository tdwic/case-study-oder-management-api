package com.bravo.system.repository;

import com.bravo.system.entity.SupplierEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplierRepository extends MongoRepository<SupplierEntity, String> {
}

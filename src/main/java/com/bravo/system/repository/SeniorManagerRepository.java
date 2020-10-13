package com.bravo.system.repository;

import com.bravo.system.entity.SeniorManagerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeniorManagerRepository extends MongoRepository<SeniorManagerEntity, String> {
}

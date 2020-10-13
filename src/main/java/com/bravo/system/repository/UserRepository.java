package com.bravo.system.repository;

import com.bravo.system.entity.SeniorManagerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<SeniorManagerEntity, String> {
}

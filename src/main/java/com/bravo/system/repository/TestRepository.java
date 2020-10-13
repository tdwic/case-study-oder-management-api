package com.bravo.system.repository;

import com.bravo.system.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<UserEntity, String> {

}

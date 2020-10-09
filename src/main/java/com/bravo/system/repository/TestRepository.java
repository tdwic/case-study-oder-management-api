package com.bravo.system.repository;

import com.bravo.system.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<User, String> {

}

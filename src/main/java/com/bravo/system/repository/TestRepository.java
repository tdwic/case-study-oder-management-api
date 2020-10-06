package com.bravo.system.repository;

import com.bravo.system.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<User, String> {

}

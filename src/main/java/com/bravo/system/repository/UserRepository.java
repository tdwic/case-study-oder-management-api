package com.bravo.system.repository;

import com.bravo.system.entity.DefaultUserEntity;
import com.bravo.system.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<DefaultUserEntity,String> {

    DefaultUserEntity findByemail(String email);

}

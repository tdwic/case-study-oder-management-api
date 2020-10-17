package com.bravo.system.repository;

import com.bravo.system.entity.OrderEntity;
import com.bravo.system.model.CodeGenerator;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CodeGenRepository  extends MongoRepository<CodeGenerator, String > {
}

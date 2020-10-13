package com.bravo.system.repository;

import com.bravo.system.entity.ProcumentStaffEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProcumentStaffRepository extends MongoRepository<ProcumentStaffEntity, String > {
}

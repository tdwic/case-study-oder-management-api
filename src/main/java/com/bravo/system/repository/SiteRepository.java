package com.bravo.system.repository;

import com.bravo.system.entity.SiteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SiteRepository extends MongoRepository<SiteEntity, String> {
}

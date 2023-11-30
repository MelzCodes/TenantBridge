package com.tenantbridge.api.repository.property;

import com.tenantbridge.api.model.property.Tenancy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenancyRepository extends MongoRepository<Tenancy, String> {
}

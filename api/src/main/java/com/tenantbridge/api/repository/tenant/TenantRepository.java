package com.tenantbridge.api.repository.tenant;

import com.tenantbridge.api.model.tenant.Tenant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends MongoRepository<Tenant, String> {
}

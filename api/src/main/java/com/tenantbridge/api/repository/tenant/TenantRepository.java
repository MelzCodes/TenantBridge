package com.tenantbridge.api.repository.tenant;

import com.tenantbridge.api.model.tenant.Tenant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class TenantRepository implements MongoRepository<Tenant, Integer> {
}

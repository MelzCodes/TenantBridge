package com.tenantbridge.api.repository.tenant;

import com.tenantbridge.api.model.tenant.TenantDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantDetailsRepository extends MongoRepository<TenantDetails, String> {
}

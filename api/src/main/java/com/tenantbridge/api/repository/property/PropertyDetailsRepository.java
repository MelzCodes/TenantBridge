package com.tenantbridge.api.repository.property;

import com.tenantbridge.api.model.property.PropertyDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDetailsRepository extends MongoRepository<PropertyDetails, String> {
}

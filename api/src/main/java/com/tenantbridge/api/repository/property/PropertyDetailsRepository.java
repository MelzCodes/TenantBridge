package com.tenantbridge.api.repository.property;

import com.tenantbridge.api.model.property.PropertyDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class PropertyDetailsRepository implements MongoRepository<PropertyDetails, Integer> {
}

package com.tenantbridge.api.repository.property;

import com.tenantbridge.api.model.property.PropertyApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class PropertyApplicationRepository implements MongoRepository<PropertyApplication, Integer> {
}

package com.tenantbridge.api.repository.property;

import com.tenantbridge.api.model.property.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class PropertyRepository implements MongoRepository<Property, Integer> {
}

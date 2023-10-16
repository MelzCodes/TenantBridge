package com.tenantbridge.api.repository.property;

import com.tenantbridge.api.model.property.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends MongoRepository<Property, String> {
}

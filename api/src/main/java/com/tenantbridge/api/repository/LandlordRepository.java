package com.tenantbridge.api.repository;

import com.tenantbridge.api.model.Landlord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandlordRepository extends MongoRepository<Landlord, String> {
}

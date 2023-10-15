package com.tenantbridge.api.repository;

import com.tenantbridge.api.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AddressRepository implements MongoRepository<Address, Integer> {
}

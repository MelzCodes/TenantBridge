package com.tenantbridge.api.repository;

import com.tenantbridge.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public abstract class UserRepository implements MongoRepository<User, Integer> {

    public Optional<User> findUserByEmail;
}

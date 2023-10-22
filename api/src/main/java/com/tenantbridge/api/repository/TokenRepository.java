package com.tenantbridge.api.repository;

import com.tenantbridge.api.model.user.Token;
import com.tenantbridge.api.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends MongoRepository<Token, String> {

    List<Token> findTokensByUserAndExpiredAndRevoked(User user, boolean expired, boolean revoked);

    Optional<Token> findByToken(String token);
}

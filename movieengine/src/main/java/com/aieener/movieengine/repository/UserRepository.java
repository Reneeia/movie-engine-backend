package com.aieener.movieengine.repository;

import com.aieener.movieengine.documents.UserDocument;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CosmosRepository<UserDocument, String> {
    Iterable<UserDocument> findByFirstName(String firstName);
}

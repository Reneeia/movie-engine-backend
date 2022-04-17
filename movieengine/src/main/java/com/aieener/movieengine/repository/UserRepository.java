package com.aieener.movieengine.repository;

import com.aieener.movieengine.documents.UserDocument;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveCosmosRepository<UserDocument, String> {
    Flux<UserDocument> findByFirstName(String firstName);
}

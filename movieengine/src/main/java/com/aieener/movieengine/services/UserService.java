package com.aieener.movieengine.services;

import com.aieener.movieengine.documents.UserDocument;
import com.aieener.movieengine.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public Mono<UserDocument> create(UserDocument user) {
        return repo.save(user);
    }

    public Flux<UserDocument> getAll() {
        return repo.findAll();
    }

    public Mono<UserDocument> getById(String id) {
        return repo.findById(id);
    }

    public Flux<UserDocument> getByFirstName (String firstName) {
        return repo.findByFirstName(firstName);
    }
}

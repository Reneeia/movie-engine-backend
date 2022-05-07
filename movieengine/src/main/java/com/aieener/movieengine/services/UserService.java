package com.aieener.movieengine.services;

import com.aieener.movieengine.documents.UserDocument;
import com.aieener.movieengine.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repo;
    private UserRepository repo1;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public UserDocument create(UserDocument user) {
        return repo.save(user);
    }

    public List<UserDocument> getAll() {
        List<UserDocument> res = new ArrayList<>();
        repo.findAll().forEach(res::add);
        return res;
    }

    public Optional<UserDocument> getById(String id) {
        return repo.findById(id);
    }

    public Iterable<UserDocument> getByFirstName (String firstName) {
        List<UserDocument> res = new ArrayList<>();
        repo.findByFirstName(firstName).forEach(res::add);
        return res;
    }
}

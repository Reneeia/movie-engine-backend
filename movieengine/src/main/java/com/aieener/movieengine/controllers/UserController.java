package com.aieener.movieengine.controllers;

import com.aieener.movieengine.documents.UserDocument;
import com.aieener.movieengine.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/user/{id}", produces = "application/json")
    public ResponseEntity<UserDocument> getUser(@PathVariable("id") String id) {
        UserDocument res = service.getById(id).block();
        HttpStatus status = res != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(res, status);
    }

    @GetMapping(value = "/user", produces = "application/json")
    public ResponseEntity<List<UserDocument>> getUsers() {
        List<UserDocument> res = service.getAll().collectList().block();
        HttpStatus status = res != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(res, status);
    }

    @PostMapping(value = "/user", produces = "application/json")
    public ResponseEntity<UserDocument> createUser(@RequestBody UserDocument user){
        UserDocument res = service.create(user).block();
        HttpStatus status = res != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(res, status);
    }
}

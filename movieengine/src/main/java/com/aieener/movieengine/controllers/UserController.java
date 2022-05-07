package com.aieener.movieengine.controllers;

import com.aieener.movieengine.documents.UserDocument;
import com.aieener.movieengine.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/user/{id}", produces = "application/json")
    public ResponseEntity<UserDocument> getUser(@PathVariable("id") String id) {
        if(service.getById(id).isPresent()){
            UserDocument res = service.getById(id).get();
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user", produces = "application/json")
    public ResponseEntity<List<UserDocument>> getUsers() {
        List<UserDocument> res = service.getAll();
        HttpStatus status = res != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(res, status);
    }

    @PostMapping(value = "/user", produces = "application/json")
    public ResponseEntity<UserDocument> createUser(@RequestBody UserDocument user){
        Optional<UserDocument> existUser = service.getById(user.getId());
        if(!existUser.isPresent()) {
            UserDocument res = service.create(user);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}

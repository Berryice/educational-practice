package com.example.pichka5051;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository repository;
    UserController(UserRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/Users")
    List<User> all() {
        return repository.findAll();
    }
    @GetMapping("/Users/{id}")
    Optional<User> id(@PathVariable Long id) {
        return repository.findById(id);
    }
    @PatchMapping("/Users/{id}")
    String edit(@PathVariable Long id, @RequestBody User user) {
        var userbid = repository.findById(id);
        if(userbid.isEmpty()){
            return "Алоооо таких тут нет";
        }
        if((user.getUser_name() == null)){
            return "Введи имя а то 5051 будешь делать Герману";
        }
        userbid.get().setUser_name(user.getUser_name());
        repository.save(userbid.get());
        return "user обновлён";
    }
    @PostMapping("/Users")
    String create(@RequestBody User user) {
        repository.save(user);
        return "user создан";
    }
    @DeleteMapping("/Users/{id}")
    String delete(@PathVariable Long id) {
        var user = repository.findById(id);
        if(user.isEmpty()){
            return "Алоооо таких тут нет";
        }
        repository.delete(user.get());
        return "user стёрт с лица земли";
    }
}
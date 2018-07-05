package com.example.anotherspringsecurity.repository;

import com.example.anotherspringsecurity.model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String s);
}
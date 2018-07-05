package com.example.anotherspringsecurity.repository;

import com.example.anotherspringsecurity.model.AppRole;
import org.springframework.data.repository.CrudRepository;

public interface AppRoleRepository extends CrudRepository<AppRole, Long> {
}
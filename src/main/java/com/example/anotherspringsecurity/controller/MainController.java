package com.example.anotherspringsecurity.controller;

import com.example.anotherspringsecurity.model.AppRole;
import com.example.anotherspringsecurity.model.AppUser;
import com.example.anotherspringsecurity.repository.AppRoleRepository;
import com.example.anotherspringsecurity.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class MainController {

    @Autowired
    AppRoleRepository roles;

    @Autowired
    AppUserRepository users;

    @PostConstruct
    public void loadData(){
        AppRole ordinaryUser = new AppRole("USER");
        roles.save(ordinaryUser);

        AppRole admin = new AppRole("ADMIN");
        roles.save(admin);

        AppUser newUser = new AppUser("user", "password");
        newUser.addRole(ordinaryUser);
        users.save(newUser);
    }
}

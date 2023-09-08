package ru.vladshag.springboot_homework.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vladshag.springboot_homework.annotations.UserId;
import ru.vladshag.springboot_homework.authority.Authorities;
import ru.vladshag.springboot_homework.entity.User;
import ru.vladshag.springboot_homework.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    @Autowired
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
    @GetMapping("/modifiedAuthorize")
    public List<Authorities> getAuthorities(@Valid @UserId User user) {
        return service.getAuthorities(user);

    }
}
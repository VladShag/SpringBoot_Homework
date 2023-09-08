package ru.vladshag.springboot_homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.vladshag.springboot_homework.authority.Authorities;
import ru.vladshag.springboot_homework.entity.User;
import ru.vladshag.springboot_homework.exceptions.InvalidCredentials;
import ru.vladshag.springboot_homework.exceptions.UnauthorizedUser;
import ru.vladshag.springboot_homework.repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    @Autowired
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }
    public List<Authorities> getAuthorities(User user) {
        return this.getAuthorities(user.getName(), user.getPassword());
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}

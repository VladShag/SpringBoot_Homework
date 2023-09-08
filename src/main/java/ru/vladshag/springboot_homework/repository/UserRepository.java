package ru.vladshag.springboot_homework.repository;

import ru.vladshag.springboot_homework.authority.Authorities;
import ru.vladshag.springboot_homework.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {
    List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        User admin = new User("admin", "admin");
        admin.setAuthorities(Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        users.add(admin);
        User user = new User("user", "user");
        user.setAuthorities(Arrays.asList(Authorities.READ, Authorities.WRITE));
        users.add(user);
        User guest = new User("guest", "guest");
        guest.setAuthorities(List.of(Authorities.READ));
        users.add(guest);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (User u : users) {
            if (u.getName().equals(user) && u.getPassword().equals(password)) {
                return u.getAuthorities();
            }
        }
        return new ArrayList<>();
    }
}

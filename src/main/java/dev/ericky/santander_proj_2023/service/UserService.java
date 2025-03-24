package dev.ericky.santander_proj_2023.service;

import dev.ericky.santander_proj_2023.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
    User create(User userToCreate);

}

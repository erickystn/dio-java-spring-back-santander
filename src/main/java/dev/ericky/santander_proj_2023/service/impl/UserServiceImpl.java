package dev.ericky.santander_proj_2023.service.impl;

import dev.ericky.santander_proj_2023.model.User;
import dev.ericky.santander_proj_2023.repository.UserRepository;
import dev.ericky.santander_proj_2023.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User userToCreate) {

        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("Usuario já existe");
        }
        return userRepository.save(userToCreate);
    }
}

package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("User tidak ditemukan"));
    }

    @Override
    public Boolean save(User user) {
        repository.save(user);
        return repository.findById(user.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        return !repository.findById(id).isPresent();
    }
}

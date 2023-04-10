package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Role;
import com.example.demo.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private RoleRepository repository;

    @Override
    public List<Role> getAll() {
        return repository.findAll();
    }

    @Override
    public Role getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("User tidak ditemukan"));
    }

    @Override
    public Boolean save(Role role) {
        repository.save(role);
        return repository.findById(role.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        return !repository.findById(id).isPresent();
    }

    public Integer getIdByLevel() {
        return repository.getIdByLevel();
    }
}

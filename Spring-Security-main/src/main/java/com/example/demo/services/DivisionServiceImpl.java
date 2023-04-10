package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Division;
import com.example.demo.repositories.DivisionRepository;

@Service
public class DivisionServiceImpl implements DivisionService {
    
    @Autowired
    private DivisionRepository repository;

    @Override
    public List<Division> getAll() {
        return repository.findAll();
    }

    @Override
    public Division getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("User tidak ditemukan"));
    }

    @Override
    public Boolean save(Division division) {
        repository.save(division);
        return repository.findById(division.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        return !repository.findById(id).isPresent();
    }

    @Override
    public List<Division> getAllDivisionJPQL(Integer id) {
        return repository.getAllDivisionJPQL(id);
    }
}

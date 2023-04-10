package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Employee;

public interface EmployeeService {
    public List<Employee> getAll();
    public Employee getById(Integer id);
    public Boolean save(Employee user);
    public Boolean delete(Integer id);
    public Integer getIdByEmail(String email);
}

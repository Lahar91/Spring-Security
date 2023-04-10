package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.MyUserDetails;
import com.example.demo.models.Employee;
import com.example.demo.models.User;
import com.example.demo.repositories.UserManagementRepository;

@Service
public class UserManagementServiceImpl {
    private final UserManagementRepository userManagementRepository;

    // @Autowired
    // private EmployeeService employeeService;

    // @Autowired
    // private RoleService roleService;

    // @Autowired
    // private UserService userService;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @Autowired
    public UserManagementServiceImpl(UserManagementRepository userManagementRepository) {
        this.userManagementRepository = userManagementRepository;
    }

    // public Boolean Register(com.example.demo.dto.Register register) {
    //     Employee employee = new Employee();
    //     employee.setName(register.getFullname());
    //     employee.setEmail(register.getEmail());
    //     employee.setBirthdate(null);
    //     com.example.demo.models.User user = new com.example.demo.models.User();
    //     user.setId(employeeService.getIdByEmail(register.getEmail()));
    //     user.setPassword(passwordEncoder.encode(register.getPassword()));
    //     user.setRole(roleService.getById(roleService.getIdByLevel()));
    //     Boolean saveEmployee = employeeService.save(employee);
    //     if(saveEmployee) {
    //         Boolean saveUser = userService.save(user);
    //         if(!saveUser) {
    //             userService.delete(user.getId());
    //             return false;
    //         }
    //         return true;
    //     }
    //     else {
    //         employeeService.delete(employeeService.getIdByEmail(employee.getEmail()));
    //     }
    //     return false;
    // }
}

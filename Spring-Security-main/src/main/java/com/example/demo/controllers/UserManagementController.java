package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.RegisterDTO;
import com.example.demo.models.Employee;
import com.example.demo.models.User;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;

@Controller
@RequestMapping("user")
public class UserManagementController {
    private AuthenticationManager authenticationManager;
    private UserService userService;
    private RoleService roleService;
    private EmployeeService employeeService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserManagementController(
            AuthenticationManager authenticationManager,
            UserService userService,
            RoleService roleService,
            EmployeeService employeeService,
            PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.roleService = roleService;
        this.employeeService = employeeService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = "login")
    public String formLogin(Model model) {
        model.addAttribute("login", new LoginDTO());
        return "user/login";
    }

    @PostMapping(value = "authenticating")
    public String submitLogin(LoginDTO login) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        login.getEmail(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/role";
    }

    @GetMapping(value = "register")
    public String formRegister(Model model) {
        model.addAttribute("register", new RegisterDTO());
        return "user/register";
    }

    @PostMapping(value = "submitRegister")
    public String submitRegister(RegisterDTO register) {
        Employee employee = new Employee();
        employee.setFullname(register.getFullname());
        employee.setEmail(register.getEmail());
        User user = new User();
        user.setPassword(passwordEncoder.encode(register.getPassword()));
        user.setRole(roleService.getById(roleService.getIdByLevel()));
        Boolean saveEmployee = employeeService.save(employee);
        if (saveEmployee) {
            user.setId(employeeService.getIdByEmail(register.getEmail()));
            Boolean saveUser = userService.save(user);
            if (!saveUser) {
                userService.delete(user.getId());
                return "redirect:/user/register";
            }
        } else {
            employeeService.delete(employeeService.getIdByEmail(employee.getEmail()));
        }
        return "user/login";
    }
}

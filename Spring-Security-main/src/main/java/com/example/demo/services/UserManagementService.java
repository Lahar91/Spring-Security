package com.example.demo.services;

import com.example.demo.dto.*;

public interface UserManagementService {
    public ResponseLogin Login(String email, String password);

    public Boolean Register(RegisterDTO register);
}

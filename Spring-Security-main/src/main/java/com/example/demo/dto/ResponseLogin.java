package com.example.demo.dto;

public class ResponseLogin {
    private Integer id;
    private String fullName;
    private String email;
    private String roleName;

    public ResponseLogin() {}

    public ResponseLogin(Integer id, String fullName, String email, String roleName) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.roleName = roleName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    } 

    public String getEmail() {
        return email;
    }

    public void setRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

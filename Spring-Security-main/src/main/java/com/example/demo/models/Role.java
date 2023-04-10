package com.example.demo.models;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "tb_m_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "nama_role", nullable = false, length = 50)
    private String nama;

    // ini adalah PK
    @OneToMany(mappedBy = "role")
    private Set<User> user; // pk

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

}

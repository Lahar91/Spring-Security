package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query(value = "SELECT r.id FROM tb_m_role r where r.level = (SELECT MAX(level) from tb_m_Role)", nativeQuery = true)
    Integer getIdByLevel();
}

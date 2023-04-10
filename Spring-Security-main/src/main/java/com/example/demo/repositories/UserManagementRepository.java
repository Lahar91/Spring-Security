package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Employee;
import com.example.demo.models.User;

@Repository
public interface UserManagementRepository extends JpaRepository<Employee, Integer> {
    // @Query(value = "select e.id, e.fullname, e.email, r.name from tb_m_user u
    // join tb_m_employee e on u.id = e.id join tb_m_role r on u.role_id = r.id
    // where email = ?1 and password = ?2", nativeQuery = true)
    // public ResponseLogin Login(String Email, String Password);

    @Query(value = "select u, r from User u join u.Employee e join u.Role r where email = ?1")
    public User Login(String Email);
}

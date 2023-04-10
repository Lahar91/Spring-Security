package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Division;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer> {
    @Query("select d, r from Division d join d.region r where d.id = :id")
    public List<Division> getAllDivisionJPQL(@Param("id") Integer id);
}

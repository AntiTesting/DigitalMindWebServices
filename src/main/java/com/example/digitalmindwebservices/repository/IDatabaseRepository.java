package com.example.digitalmindwebservices.repository;

import com.example.digitalmindwebservices.entities.Database;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IDatabaseRepository extends JpaRepository<Database, Long> {
    List<Database> findDatabasesByName(String name);
}

package com.example.test_project_only_description.repository;

import com.example.test_project_only_description.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByDni(String dni);
    boolean existsByEmail(String email);
} 
package com.example.demo.Repository;

import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findByToken(String token);
    boolean existsByToken(String token);
}

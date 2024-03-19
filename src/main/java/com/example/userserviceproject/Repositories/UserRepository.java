package com.example.userserviceproject.Repositories;

import com.example.userserviceproject.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User save(User user);
    Optional<User> findByEmailAndHashedPassword(String email, String hashedPassword);
}

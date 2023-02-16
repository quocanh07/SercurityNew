package com.example.springsercutiy.Repository;

import com.example.springsercutiy.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

package com.example.Event_Management.Repository;

import com.example.Event_Management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

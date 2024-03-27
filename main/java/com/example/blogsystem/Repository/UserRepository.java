package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUserId(Integer user_id);
    User findUserByEmail(String email);
    User findUserByUsername(String username);
}

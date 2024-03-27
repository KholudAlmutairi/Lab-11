package com.example.blogsystem.Service;

import com.example.blogsystem.ApiResponse.ApiException;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //• Get all the Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //• Add new User
    public void addUser(User user) {
        userRepository.save(user);
    }

    //• Update User
    public void updateUser(Integer user_id,User user) {
        User u=userRepository.findUserByUserId(user_id);
        if (u == null) {
            throw new ApiException("Wrong id");
        }

// • user_id
//• username
//• password
//• email
//• registration_date

        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        u.setRegistrationDate(user.getRegistrationDate());
        userRepository.save(u);
    }


    //• Delete User
    public void deleteUser(Integer user_id) {
        User u=userRepository.findUserByUserId(user_id);
        if (u == null) {
            throw new ApiException("Wrong id");
        }
        userRepository.delete(u);



    }


    //• Get user by email endpoint #1
    public User searchByEmail(String email){
        User user=userRepository.findUserByEmail(email);
        if (user == null) {
            throw new ApiException("Email not found");
        }
        return user;
    }


    //• Check if username and password are correct  endpoint #2
    public void authenticate(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new ApiException("username not found");
        }
        password.equals(user.getPassword());

        }
    }






















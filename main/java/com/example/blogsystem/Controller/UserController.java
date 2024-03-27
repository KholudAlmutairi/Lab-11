package com.example.blogsystem.Controller;

import com.example.blogsystem.ApiResponse.ApiResponse;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers(){

        return ResponseEntity.status(200).body(userService.getAllUsers());}


    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);

        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User Added"));

    }


    @PutMapping("/update/{user_id}")
    public ResponseEntity updateUser(@PathVariable Integer user_id, @RequestBody @Valid User user , Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);
        }

        userService.updateUser(user_id,user);
        return ResponseEntity.status(200).body(new ApiResponse( "User updated"));
    }

    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity deleteUser(@PathVariable Integer user_id){
        userService.deleteUser(user_id);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted!"));
    }

    //endpoint #1

    @GetMapping("/searchByEmail/{email}")
    public  ResponseEntity searchByEmail (@PathVariable String email){

        return ResponseEntity.status(200).body(userService.searchByEmail(email));

    }

    // Check if username and password are correct

    //endpoint #2
    @PostMapping("/authenticate/{username}/{password}")
    public ResponseEntity authenticateUser(@PathVariable String username, @PathVariable String password) {
        userService.authenticate(username, password);
        return ResponseEntity.status(200).body(new ApiResponse("Authentication successful!"));
    }







}

package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    // • user_id:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotEmpty(message = "user_id can not null")
    private Integer userId;

    // username :
    //Cannot be null
    //Length more than 4
    //must be unique

    @NotEmpty(message = "username can not null")
    @Size(min = 4,message = "username length more than 4")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String username;


    // password :
    // Cannot be null
    @NotEmpty(message = "password can not null")
    @Column(columnDefinition = "varchar(30) not null")
    private String password;

    //email :
    //Cannot be null
    // must be valid email
    // must be unique
    @NotEmpty(message = "email can not null")
    @Email(message = "email must be valid email")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;


//    //• registration_date
//     @NotEmpty(message = "password can not null")
//     @Column(columnDefinition = "Date not null")
//     private Date registrationDate;
//    private Date registration_date;


    //• registration_date
     @Column(columnDefinition = "Date not null")
     private Date registrationDate;
















}

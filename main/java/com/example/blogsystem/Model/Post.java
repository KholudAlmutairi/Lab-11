package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Post {

//• post_id
//• category_id
//• title
//• content
//• user_id
//• publish_date
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @NotNull(message = "categoryId cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer categoryId;


    @NotEmpty(message = "Title cannot be null")
    @Size(min = 4,message = "Name length must be more than 4 characters.")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;


    @NotEmpty(message = "content cannot be null")
    @Column(columnDefinition = "varchar(255)  not null")
    private  String content;


    @NotNull(message = "userId cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;


    @Column(columnDefinition = "Date not null")
    private Date publishDate;
    //LocalDate






}

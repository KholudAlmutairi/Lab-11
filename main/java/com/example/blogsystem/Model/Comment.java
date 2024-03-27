package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Comment {

    //• user_id
   //• post_id
  //• content
 //• comment_date



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotEmpty(message = "id can not null")
    private Integer commentId;

    @NotNull(message = "userId cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;


    @NotNull(message = "postId cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer postId;

    @NotEmpty(message = "content cannot be null")
    @Column(columnDefinition = "varchar(255)  not null")
    private  String content;

    @Column(columnDefinition = "Date not null")
    private Date commentDate;




}

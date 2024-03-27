package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor

public class Category {


    //ID :
    //Cannot be null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotEmpty(message = "id can not null")
    private Integer categoryId;

    //name :
    //Cannot be null
    //Length more than 4
    @NotEmpty(message = "Name can not null")
    @Size(min = 4,message = "Name length more than 4")
    @Column(columnDefinition = "varchar(30) not null ")//unique
    private String name;




}

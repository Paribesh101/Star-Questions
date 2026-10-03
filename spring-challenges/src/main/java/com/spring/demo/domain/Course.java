package com.spring.demo.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity 
@Table(name = "course")
public class Course {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @NotBlank
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    public Course(){}

    public Course(String name){
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}

package com.shortener.shortener.model;

import java.io.Serializable;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor

public class Url implements Serializable{

    private static final long serialVersionUID = 1L; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long  id;

    private String longUrl;

    public Url(String longUrl){
        this.longUrl = longUrl;
    }

}

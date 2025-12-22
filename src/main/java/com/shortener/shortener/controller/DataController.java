package com.shortener.shortener.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RequestMapping("/short")
public class DataController {
    

    @PostMapping
    public void shortenUrl(){
        
    }

    @GetMapping()
    public void listShorten(){
    
    }

}

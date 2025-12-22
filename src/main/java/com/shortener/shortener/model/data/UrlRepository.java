package com.shortener.shortener.model.data;

import org.springframework.data.repository.CrudRepository;

import com.shortener.shortener.model.Url;

public interface UrlRepository extends CrudRepository<Url,String>{
    
}

package com.shortener.shortener.model.data;

import org.springframework.data.jpa.repository.JpaRepository;


import com.shortener.shortener.model.Url;

public interface UrlRepository extends JpaRepository<Url,Long>{
    
}

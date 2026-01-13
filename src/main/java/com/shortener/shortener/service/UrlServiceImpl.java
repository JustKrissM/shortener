package com.shortener.shortener.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shortener.shortener.model.Url;
import com.shortener.shortener.model.data.UrlRepository;

@Service
public class UrlServiceImpl  implements UrlService{
    
    private final UrlRepository repository;


    // constructor injection 
    public UrlServiceImpl(UrlRepository repository){
        this.repository =repository;
    }

     @Override
    public Url saveUrl(Url url) {
         return repository.save(url);
    }

    @Override
    public Optional<Url> getUrl(Long id){

        return repository.findById(id);
    }
    
    @Override
    public List<Url> getAllUrl(){
        return repository.findAll();
    }
     
}

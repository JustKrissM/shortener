package com.shortener.shortener.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shortener.shortener.model.Url;

@Service
public interface UrlService {

    public Url  saveUrl(Url url);

   public Optional<Url> getUrl(Long id);

   public List<Url> getAllUrl();  
} 
package com.shortener.shortener.controller;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.shortener.shortener.controller.utils.ShortenerUtils;
import com.shortener.shortener.model.Url;
import com.shortener.shortener.model.data.UrlRepository;
import com.shortener.shortener.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/short")
public class DataController {
    
    private UrlService urlsService;
    public DataController(UrlService urlService){
        this.urlsService = urlService; 
    }

    @GetMapping("/")
    public String showUrl(@RequestParam Long id){

        String encodedUrl = ShortenerUtils.encodeBase62Reverse(new BigInteger("3021614606208"));
        return "Sucess new url : "+encodedUrl;
    }


    @GetMapping("/{shortUrl:[a-z0-9]+}")
    public  RedirectView  getRedirected(@PathVariable String shortUrl){
        Optional<Url> redirectUrl =urlsService.getUrl(ShortenerUtils.decodeBase62(shortUrl)); 
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectUrl.get().getLongUrl());
        return redirectView;
           
 
    }
    @PostMapping("/url")
    public String shortenUrl(@RequestBody Url url){
        boolean protocol = url.getLongUrl().contains("https://") || url.getLongUrl().contains("http://");
        Url finalUrl = protocol?url:new Url(url.getId(),"https://"+url.getLongUrl());
        //String encodedUrl = ShortenerUtils.encodeBase62Reverse(new BigInteger("3021614606208"));
        urlsService.saveUrl(finalUrl);
        return "success url shortened";
    }
   

   
    

}

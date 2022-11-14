package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/consumer")
public class Usercontroller {

    @Autowired
    private RestTemplate restTemplate;
    static  final  String WEBSITES="https://cloud-producer.azurewebsites.net/";

    
   @RequestMapping("/test-ok")
    public String testOk() {
        return "ok";
    }

    @RequestMapping("/select-count")
    public Integer selectCount(){
        String url = WEBSITES+"user/select-count";
        return restTemplate.getForObject(url, Integer.class);
    }

 




}

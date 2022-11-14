package com.example.demo.controller;

import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/consumer")
public class Usercontroller {

    @Autowired
    private RestTemplate restTemplate;


    static  final  String WEBSITES="https://cloud-producer.azurewebsites.net/";

    @RequestMapping("/select-count")
    public Integer selectCount(){
        String url = WEBSITES+"user/select-count";
        return restTemplate.getForObject(url, Integer.class);
    }

    @RequestMapping("/find-user")
    public List<User> findAllByDb() {
        String url = WEBSITES+"user/find-user";
        List<User> userList = restTemplate.getForObject(url, List.class);
        return userList;
    }

    @RequestMapping("/get-cache-users")
    public List<User> findAllByCache() {
        String url = WEBSITES+"user/get-cache-users";
        List<User> userList = restTemplate.getForObject(url, List.class);
        return userList;
    }

    @RequestMapping("/find/{id}")
    public User findUserById(@PathVariable(value = "id") Integer id) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("id",id);
        String url = WEBSITES+"user/find/{id}";
        User user = restTemplate.getForObject(url, User.class,map);
        return user;
    }












}
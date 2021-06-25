package com.example.qltvtt.controller;

import com.example.qltvtt.entity.User;
import com.example.qltvtt.entitywrapper.UserWrapper;
import com.example.qltvtt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/users",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/user",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public User addUser(@RequestBody User use) {
        return userRepository.save(use);
    }

    @RequestMapping(value = "/user",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public User updateUser(@RequestBody UserWrapper use) {
        User user = new User(use);
        System.out.println("use:" + use);
        return userRepository.save(user);
    }

    @RequestMapping(value = "/user/{useId}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteUser(@PathVariable("useId") Integer useId) {
        userRepository.deleteById(useId);
    }

    @RequestMapping(value = "user")
    public String user() {

        return "user";
    }

    @RequestMapping(value = "user2")
    public String user2() {

        return "user2";
    }
}

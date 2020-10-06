package com.bravo.system.controller;

import com.bravo.system.model.User;
import com.bravo.system.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "user" , method = RequestMethod.POST)
    public User RegUser(@RequestBody User user){
        System.out.println(user.getTestID());
        return testService.NewUser(user);
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public List<User> GetAllUsers(){
        return testService.gettAll();
    }


}

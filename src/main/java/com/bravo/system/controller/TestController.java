package com.bravo.system.controller;

import com.bravo.system.entity.UserEntity;
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
    public UserEntity RegUser(@RequestBody UserEntity userEntity){
        //System.out.println(user.getTestID());
        return testService.NewUser(userEntity);
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public List<UserEntity> GetAllUsers(){
        return testService.gettAll();
    }


}

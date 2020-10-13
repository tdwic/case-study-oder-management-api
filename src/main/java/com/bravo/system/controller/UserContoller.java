package com.bravo.system.controller;

import com.bravo.system.model.SeniorManager;
import com.bravo.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "htttp://localhost:4200")
@RequestMapping("/")
public class UserContoller {

    @Autowired
    private UserService userService;


}

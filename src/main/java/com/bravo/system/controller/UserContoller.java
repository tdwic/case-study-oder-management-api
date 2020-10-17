package com.bravo.system.controller;

import com.bravo.system.entity.DefaultUserEntity;
import com.bravo.system.model.ProcumentStaff;
import com.bravo.system.model.SeniorManager;
import com.bravo.system.model.Supplier;
import com.bravo.system.model.UserValidity;
import com.bravo.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "htttp://localhost:4200")
@RequestMapping("/")
public class UserContoller {

    @Autowired
    private UserService userService;

    //Post Methods
    @RequestMapping(value = "seniorManager",method = RequestMethod.POST)
    public DefaultUserEntity NewSeniorManager(@RequestBody SeniorManager seniorManager){
        return userService.NewSeniorManager(seniorManager);
    }

    @RequestMapping(value = "procumentStaff",method = RequestMethod.POST)
    public DefaultUserEntity NewProcumentStaff(@RequestBody ProcumentStaff procumentStaff){
        return userService.NewProcumentStaff(procumentStaff);
    }

    @RequestMapping(value = "supplier",method = RequestMethod.POST)
    public DefaultUserEntity NewSupplier(@RequestBody Supplier supplier){
        return userService.NewSupplier(supplier);
    }

    //Post Methods

    //GET Methods
    @RequestMapping(value = "allUser",method = RequestMethod.GET)
    public List<DefaultUserEntity> GetAllUser(){
        return userService.GetAllUsers();
    }

    @RequestMapping(value = "allSuppliers",method = RequestMethod.GET)
    public List<DefaultUserEntity> GetAllSuppliers(){
        return userService.GetAllSuppliers();
    }

     //GET Methods

    //Validate User
    @RequestMapping(value = "validate",method = RequestMethod.POST)
    public boolean ValidateUser(@RequestBody UserValidity userValidity){
        return userService.ValidateUser(userValidity);
    }
    //Validate User

}

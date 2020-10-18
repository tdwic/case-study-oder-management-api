package com.bravo.system.controller;

import com.bravo.system.entity.DefaultUserEntity;
import com.bravo.system.model.*;
import com.bravo.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000")
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

    @RequestMapping(value = "siteManager",method = RequestMethod.POST)
    public DefaultUserEntity NewSupplier(@RequestBody SiteManager siteManager){
        return userService.NewSiteManager(siteManager);
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

    @RequestMapping(value = "allSiteManagers",method = RequestMethod.GET)
    public List<DefaultUserEntity> GetAllSiteManagers(){
        return userService.GetAllSiteManagers();
    }

     //GET Methods

    //Validate User
    @RequestMapping(value = "validate",method = RequestMethod.POST)
    public boolean ValidateUser(@RequestBody UserValidity userValidity){
        return userService.ValidateUser(userValidity);
    }
    //Validate User

}

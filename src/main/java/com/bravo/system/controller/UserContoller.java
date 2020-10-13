package com.bravo.system.controller;

import com.bravo.system.entity.ProcumentStaffEntity;
import com.bravo.system.entity.SeniorManagerEntity;
import com.bravo.system.entity.SupplierEntity;
import com.bravo.system.model.ProcumentStaff;
import com.bravo.system.model.SeniorManager;
import com.bravo.system.model.Supplier;
import com.bravo.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.ServerEndpoint;

@RestController
@CrossOrigin(value = "htttp://localhost:4200")
@RequestMapping("/")
public class UserContoller {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "seniorManager",method = RequestMethod.POST)
    public SeniorManagerEntity NewSeniorManager(@RequestBody SeniorManager seniorManager){
        return userService.NewSeniorManager(seniorManager);
    }

    @RequestMapping(value = "procumentStaff",method = RequestMethod.POST)
    public ProcumentStaffEntity NewProcumentStaff(@RequestBody ProcumentStaff procumentStaff){
        return userService.NewProcumentStafe(procumentStaff);
    }

    @RequestMapping(value = "supplier",method = RequestMethod.POST)
    public SupplierEntity NewSupplier(@RequestBody Supplier supplier){
        return userService.NewSupplier(supplier);
    }

}

package com.bravo.system.controller;

import com.bravo.system.entity.OrderEntity;
import com.bravo.system.model.Order;
import com.bravo.system.service.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/")
public class OderController {
    @Autowired
    private OrderServices orderServices;

    @RequestMapping(value = "saveOrder" , method = RequestMethod.POST)
    public String SaveNewOrder(@RequestBody Order order){
        //System.out.println(user.getTestID());
        return orderServices.AddOrders(order);
    }

    @RequestMapping(value = "getOrders", method = RequestMethod.GET)
    public List<OrderEntity> GetAllOrders(){
        return orderServices.GetOrders();
    }

    @RequestMapping(value = "getOrderDetailsByOrderId", method = RequestMethod.GET)
    public Optional<OrderEntity> GetOrderById(String Id){
        return orderServices.GetOrderDetailsByOrderId(Id);
    }

}


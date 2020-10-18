package com.bravo.system.controller;

import com.bravo.system.entity.OrderEntity;
import com.bravo.system.entity.ProductEntity;
import com.bravo.system.model.Order;
import com.bravo.system.model.OrderReurnModel;
import com.bravo.system.model.OrderUpdateModel;
import com.bravo.system.service.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping("/")
public class OderController {

    private final OrderServices orderServices;

    public OderController(OrderServices orderServices) {
        this.orderServices = orderServices;
    }

    @RequestMapping(value = "saveOrder" , method = RequestMethod.POST)
    public OrderReurnModel SaveNewOrder(@RequestBody Order order){
        //System.out.println(user.getTestID());
        return orderServices.AddOrders(order);
    }

    @RequestMapping(value = "getOrders", method = RequestMethod.GET)
    public List<OrderEntity> GetAllOrders(){
        return orderServices.GetOrders();
    }

    @RequestMapping(value = "getOrderDetailsByOrderId", method = RequestMethod.GET)
    public Optional<OrderEntity> GetOrderById(String Id){
        return orderServices.GetOrderDetailsByOrderNo(Id);
    }

    @RequestMapping(value = "updateStatus" , method = RequestMethod.POST)
    public boolean UpdateStatus(@RequestBody OrderUpdateModel model){
        return orderServices.UpdateStatus(model);
    }

    @RequestMapping(value = "findByorderNo/{no}", method = RequestMethod.GET)
    public OrderEntity findByorderNo(@PathVariable String no) {
        return orderServices.FindbyOderNo(no);
    }

    @RequestMapping(value = "getPendingOrders", method = RequestMethod.GET)
    public List<OrderEntity> GetPendingOrders(){
        return orderServices.GetPendingOrders();
    }
}


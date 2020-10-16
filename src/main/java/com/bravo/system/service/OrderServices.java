package com.bravo.system.service;

import com.bravo.system.entity.OrderEntity;
import com.bravo.system.model.Order;
import com.bravo.system.repository.OrderRepository;
import com.bravo.system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    //Post Methods
    public boolean AddOrders(Order order){

        OrderEntity obj = new OrderEntity();

        obj.setSite(order.getSite());
        obj.setTotalPrice(order.getTotalPrice());
        obj.setDueDate(order.getDueDate());
        obj.setOrderDate(order.getOrderDate());
        obj.setOrderStatus(order.getOrderStatus());
        obj.setSupplier(order.getSupplier());
        obj.setSupplierStatus(order.getSupplierStatus());
        obj.setApprovelNote(order.getDeliveryNote());
        obj.setApprovelManager(order.getApprovelManager());
        obj.setDeliveryNote(order.getDeliveryNote());
        obj.setInquiry(order.getInquiry());


        OrderEntity result =orderRepository.save(obj);
        if(result.getId() != null || result.getId() != ""){
            productRepository.saveAll(order.getItems());
        }
        return false;

    }

    public List<OrderEntity> GetOrders(){
        List<OrderEntity> list = orderRepository.findAll();
        return list;
    }

    public Optional<OrderEntity> GetOrderDetailsByOrderId(String id){

        return orderRepository.findById(id);

    }
}

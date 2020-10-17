package com.bravo.system.service;

import com.bravo.system.entity.OrderEntity;
import com.bravo.system.entity.ProductEntity;
import com.bravo.system.model.CodeGenerator;
import com.bravo.system.model.Order;
import com.bravo.system.repository.CodeGenRepository;
import com.bravo.system.repository.OrderRepository;
import com.bravo.system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CodeGenRepository codeGenRepository;



    //Post Methods
    public String AddOrders(Order order){

        List<CodeGenerator> cd = codeGenRepository.findAll();
        int id = cd.get(0).getValue();

        int length = String.valueOf(id).length();
        String code ="";
        int codeval = id+1;


       switch (length){

           case 1 : code = "B0000" + id;
                    break;
           case 2 : code = "B000" + id;
                    break;
           case 3 : code = "B00" + id;
                    break;
           case 4 : code = "B0" + id;
                     break;
           case 5 : code = "B" + id;
                    break;
       }

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
        obj.setOrderId(codeval);
        obj.setOrderNo(code);
        obj.setSiteManager(order.getSiteManager());

        OrderEntity result =orderRepository.save(obj);

        CodeGenerator incrementedVal=new CodeGenerator();
        incrementedVal.setId(cd.get(0).getId());
        incrementedVal.setValue(codeval);
        codeGenRepository.save(incrementedVal);



        if(result.getId() != null || result.getId() != ""){


                return String.valueOf(code) ;

        }
        return "00";


    }

    public List<OrderEntity> GetOrders(){
        List<OrderEntity> list = orderRepository.findAll();
        return list;
    }

    public Optional<OrderEntity> GetOrderDetailsByOrderNo(String id){

        return orderRepository.findById(id);

    }

    public boolean UpdateStatus(OrderEntity order){

        OrderEntity or = orderRepository.save(order);
        if(or.getId() != null || or.getId() != ""){
            return true ;
        }

        return false;

    }

    public OrderEntity FindbyOderNo(String orderno){
       return  orderRepository.findByOrderNo(orderno);
    }
}

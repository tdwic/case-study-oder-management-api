package com.bravo.system.service;

import com.bravo.system.entity.OrderEntity;
import com.bravo.system.entity.ProductEntity;
import com.bravo.system.model.CodeGenerator;
import com.bravo.system.model.Order;
import com.bravo.system.model.OrderReurnModel;
import com.bravo.system.model.OrderUpdateModel;
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
    //Injecting dependancies
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CodeGenRepository codeGenRepository;

    public OrderServices(OrderRepository orderRepository, ProductRepository productRepository, CodeGenRepository codeGenRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.codeGenRepository = codeGenRepository;
    }


    //save new order
    public OrderReurnModel AddOrders(Order order){

        OrderReurnModel returnmodel = new OrderReurnModel();
        try {
            //current incremental value for create order no
            List<CodeGenerator> cd = codeGenRepository.findAll();
            int id = cd.get(0).getValue();

            //length of the value
            int length = String.valueOf(id).length();
            String code = "";
            int codeval = id + 1;

            //creating orderno according to value leangth
            switch (length) {

                case 1:
                    code = "B0000" + id;
                    break;
                case 2:
                    code = "B000" + id;
                    break;
                case 3:
                    code = "B00" + id;
                    break;
                case 4:
                    code = "B0" + id;
                    break;
                case 5:
                    code = "B" + id;
                    break;
            }

            //mapping to orderEntity to save in databse
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

            //database saving method
            OrderEntity result = orderRepository.save(obj);

            //incrementing codegenerator value by 1
            CodeGenerator incrementedVal = new CodeGenerator();
            incrementedVal.setId(cd.get(0).getId());
            incrementedVal.setValue(codeval);
            codeGenRepository.save(incrementedVal);



            //check whether record is inserted
            if (result.getId() != null || result.getId() != "") {

                returnmodel.setOrderNo(code);
                return returnmodel;

            }
            //if not return value with "0000000"
            returnmodel.setOrderNo("0000000");
            return returnmodel;
        }catch(Exception e){
            //handling exceptions
            returnmodel.setOrderNo(e.toString());
            return returnmodel;
        }
    }

    //get all orders method returning list of orders
    public List<OrderEntity> GetOrders(){
        try{
            List<OrderEntity> list = orderRepository.findAll();
            return list;
        }catch (Exception e){
            //handling exceptions
            return null;
        }

    }

    //selecting single order according to its order no
    public Optional<OrderEntity> GetOrderDetailsByOrderNo(String id){
        try {
            return orderRepository.findById(id);
        }catch (Exception e){
            return null;
        }
    }

    //updating order status as completed/delivered/pending
    public boolean UpdateStatus(OrderUpdateModel model){
        try {
            OrderEntity oe = orderRepository.findByOrderNo(model.getOrderno());
            oe.setOrderStatus(model.getStatus());
            OrderEntity or = orderRepository.save(oe);

            if (or.getId() != null || or.getId() != "") {
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }


    }


    public OrderEntity FindbyOderNo(String orderno){
        try {
       return  orderRepository.findByOrderNo(orderno);
        }catch (Exception e){
            return null;
        }
    }

    //get pending status orders
    public List<OrderEntity> GetPendingOrders()
    {
        try {
       return orderRepository.findAllByOrderStatusIs("pending");
        }catch (Exception e){
            return null;
        }
    }

    //get completed status orders
    public List<OrderEntity> GetCompltedOrders()
    {
        try {
        return orderRepository.findAllByOrderStatusIs("completed");
        }catch (Exception e){
            return null;
        }
    }

    //get  not completed status orders
    public List<OrderEntity> GetUnCompltedOrders()
    {
        try {
        return orderRepository.findAllByOrderStatusIsNot("completed");
        }catch (Exception e){
            return null;
        }
    }
}

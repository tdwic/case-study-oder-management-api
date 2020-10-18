package com.bravo.system.service;


import com.bravo.system.entity.ProductEntity;
import com.bravo.system.entity.Product_OrderEntity;
//import com.bravo.system.entity.SeniorManagerEntity;
import com.bravo.system.model.Product;
import com.bravo.system.model.SeniorManager;
import com.bravo.system.repository.ProductOderRepository;
import com.bravo.system.repository.ProductRepository;
//import com.bravo.system.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    //Injecting dependancies using Autowired
    @Autowired
    private ProductRepository productRepository;
    private ProductOderRepository productOderRepository;

   //Add products
    public boolean AddProducts(Product product){
        try {
            ProductEntity obj = new ProductEntity();

            obj.setId(product.getId());
            obj.setName(product.getName());
            obj.setPrice(product.getPrice());
            obj.setQuantity(product.getQuantity());
            obj.setStatus(product.getStatus());
            obj.setSupplier(product.getSupplier());
            obj.setUnit(product.getUnit());
            obj.setOrderNo(product.getOrderNo());


            ProductEntity result = productRepository.save(obj);
            if (result.getId() != null || result.getId() == "") {
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }


    }

    //get all products
    public List<ProductEntity> GetProducts(){
        try {
       List<ProductEntity> list = productRepository.findAll();
        return list;
        }catch(Exception e){
            return null;
        }
    }

    //get products according to orderno
    public List<ProductEntity> GetProductsByOrderNo(String orderNo){
        try {
        return productRepository.findByOrderNo(orderNo);
        }catch(Exception e){
            return null;
        }
    }


}

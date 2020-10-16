package com.bravo.system.controller;

import com.bravo.system.entity.ProductEntity;
import com.bravo.system.entity.Product_OrderEntity;
import com.bravo.system.model.Product;
import com.bravo.system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "saveOrder", method = RequestMethod.POST)
    public boolean RegUser(@RequestBody Product order) {
        //System.out.println(user.getTestID());
        return productService.AddProducts(order);
    }

    @RequestMapping(value = "getproducts", method = RequestMethod.GET)
    public List<ProductEntity> GetAllProducts() {
        return productService.GetProducts();
    }

    @RequestMapping(value = "getOrderDetailsById", method = RequestMethod.GET)
    public List<Product_OrderEntity> GetProductsByOrderId(String orderId) {
        return productService.GetProductsByOrderId(orderId);
    }
}

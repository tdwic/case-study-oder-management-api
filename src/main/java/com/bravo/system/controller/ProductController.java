package com.bravo.system.controller;

import com.bravo.system.entity.ProductEntity;
import com.bravo.system.entity.Product_OrderEntity;
import com.bravo.system.model.Product;
import com.bravo.system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "saveProduct", method = RequestMethod.POST)
    public boolean saveproduct(@RequestBody Product order) {
        //System.out.println(user.getTestID());

        return productService.AddProducts(order);
    }

    @RequestMapping(value = "getproducts", method = RequestMethod.GET)
    public List<ProductEntity> GetAllProducts() {
        return productService.GetProducts();
    }

    @RequestMapping(value = "getOrderDetailsByNo/{id}", method = RequestMethod.GET)
    public List<ProductEntity> GetProductsByOrderId(@PathVariable String id) {
        return productService.GetProductsByOrderNo(id);
    }
}

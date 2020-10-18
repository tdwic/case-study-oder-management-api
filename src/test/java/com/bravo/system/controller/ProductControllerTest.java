package com.bravo.system.controller;

import com.bravo.system.model.Product;
import com.bravo.system.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class ProductControllerTest extends AbstractTest {

    public static final String ID = "1L";
    public static final String PRODUCT_NAME = "Cement";
    public static final int UNIT = 3;
    public static final String QUANTITY = "10" ;
    public static final String PRICE = "1000";
    public static final String SUPPLIER = "Sanjeewa";
    public static final String ORDER_NUMBER = "B0001";
    public static final int STATUS = 1;

    /**
     * Overridden method of the extends abstract class
     */
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    /**
     * Unit Testing for Save Product
     */
    @Test
    public void saveproduct() {
        try {
            String uri = "/saveProduct";
            Product product = new Product();
            product.setId(ID);
            product.setName(PRODUCT_NAME);
            product.setUnit(UNIT);
            product.setQuantity(QUANTITY);
            product.setPrice(PRICE);
            product.setSupplier(SUPPLIER);
            product.setOrderNo(ORDER_NUMBER);
            product.setStatus(STATUS);
            String inputJson = super.mapToJson(product);
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(inputJson)).andReturn();

            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);

            Boolean content = Boolean.parseBoolean(mvcResult.getResponse().getContentAsString());
            assertTrue(content);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get ALl Products Unit Test
     */
    @Test
    public void getAllProducts() {
        try {
            String uri = "/getproducts";
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                    .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();


            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            Product[] product = super.mapFromJson(content, Product[].class);
            assertTrue(product.length > 0);

        }catch(UnsupportedEncodingException e){
            e.printStackTrace();

        }catch(IOException e){
            e.printStackTrace();

        }catch(Exception e){
            e.printStackTrace();

        }
    }

    /**
     * Unit Test for getProductByOrderId
     */
    @Test
    public void getProductsByOrderId() {
        try {
            String uri = "/getOrderDetailsByNo/1L";
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
            int status = mvcResult.getResponse().getStatus();
            assertNotEquals(400, status);
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();

        }catch(IOException e){
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

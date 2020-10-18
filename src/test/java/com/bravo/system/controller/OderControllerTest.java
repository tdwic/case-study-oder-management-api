package com.bravo.system.controller;

import com.bravo.system.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class OderControllerTest extends AbstractTest{
    static String d1 = "2020-10-25";
    static String d2 = "2020-10-18" ;

    static Date date1;
    static Date date2;

    static {
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(d1);
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static final String ID = "1L";
    public static final String SITE = "Colombo";
    public static final float TOTAL_PRICE = 10000;
    public static final Date DUE_DATE = date1;
    public static final Date ORDER_DATE = date2;
    public static final String ORDER_STATUS = "completed";
    public static final String SUPPLIER = "Kamal";
    public static final String SUPPLIER_STATUS = "1";
    public static final String SITE_MANAGER = "Ashok";


    /**
     * Overridden method of the extends abstract class
     */
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    /**
     * Unit Test for Adding a New Order
     */
    @Test
    public void saveNewOrder() {
        try {
            String uri = "/saveOrder";
            Order order = new Order();
            order.setId(ID);
            order.setSite(SITE);
            order.setTotalPrice(TOTAL_PRICE);
            order.setDueDate(DUE_DATE);
            order.setOrderDate(ORDER_DATE);
            order.setOrderStatus(ORDER_STATUS);
            order.setSupplier(SUPPLIER);
            order.setSupplierStatus(SUPPLIER_STATUS);
            order.setSiteManager(SITE_MANAGER);
            String inputJson = super.mapToJson(order);
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(inputJson)).andReturn();

            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Unit Test for GetAllOrders Method
     */
    @Test
    public void getAllOrders() {
        try {
            String uri = "/getOrders";
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                    .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();


            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            Order[] order = super.mapFromJson(content, Order[].class);
            assertTrue(order.length > 0);

        }catch(UnsupportedEncodingException e){
            e.printStackTrace();

        }catch(IOException e){
            e.printStackTrace();

        } catch(Exception e){
            e.printStackTrace();

        }
    }

    @Test
    public void getOrderById() {
    }

    @Test
    public void updateStatus() {
    }

    @Test
    public void findByorderNo() {
    }

    @Test
    public void getPendingOrders() {
        try {
            String uri = "/getPendingOrders";
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                    .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();


            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            Order[] order = super.mapFromJson(content, Order[].class);
            assertTrue(order.length > 0);

        }catch(UnsupportedEncodingException e){
            e.printStackTrace();

        }catch(IOException e){
            e.printStackTrace();

        } catch(Exception e){
            e.printStackTrace();

        }
    }

    @Test
    public void getCompletedOrders() {
    }

    @Test
    public void getUnCompletedOrders() {
    }
}

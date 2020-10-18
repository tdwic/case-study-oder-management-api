package com.bravo.system.controller;

import com.bravo.system.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;


public class UserContollerTest extends AbstractTest {

    public static final String id = "1L";
    public static final String firstName = "Ashok";
    public static final String lastName = "Perera";
    public static final String email = "ashok@gmail.com";
    public static final String password = "abcd123";
    public static final String role_SeniorManaer = "SeniorManager";
    public static final String role_ProcumentStaff = "ProcumentStaff";
    public static final String role_Supplier = "supplier";
    public static final String role_SiteManager = "siteManager";

    public static final String SENIOR_MANAGER_EXPECTED = "{\"id\":\"1L\",\"fName\":\"Ashok\",\"lName\":\"Perera\",\"email\":\"ashok@gmail.com\",\"password\":\"abcd123\",\"role\":\"SeniorManager\",\"company\":\"\",\"site\":\"\"}";

    /**
     * Overridden method of the extends abstract class
     */
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }



    /**
     * Unit Testing to Add SeniorMangers
     */
    @Test
    public void newSeniorManagerTest() {
        try {
            String uri = "/seniorManager";
            User user = new User(id, firstName, lastName, email, password, role_SeniorManaer);
            String inputJson = super.mapToJson(user);
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(inputJson)).andReturn();

            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);

            String content = mvcResult.getResponse().getContentAsString();
            assertEquals(content, SENIOR_MANAGER_EXPECTED );
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Unit Testing to Add ProcumentStaff
     */
    @Test
    public void newProcumentStaffTest() {
        try {
            String uri = "/procumentStaff";
            User user = new User(id, firstName, lastName, email, password, role_ProcumentStaff);
            String inputJson = super.mapToJson(user);
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
     * Unit Testing to Add Suppliers
     */
    @Test
    public void newSupplierTest() {
        try {
            String uri = "/supplier";
            User user = new User(id, firstName, lastName, email, password, role_Supplier);
            String inputJson = super.mapToJson(user);
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
     * Unit Testing to Add Site Manager
     */
    @Test
    public void newSiteManagerTest() {
        try {
            String uri = "/siteManager";
            User user = new User(id, firstName, lastName, email, password, role_SiteManager);
            String inputJson = super.mapToJson(user);
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
     * Using Asserts to Check Whether there will be an
     * result from  /allUsers.
     */
    @Test
    public void getAllUserTest() {
        try {
            String uri = "/allUser";
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                    .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();


            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            User[] user = super.mapFromJson(content, User[].class);
            assertTrue(user.length > 0);

        }catch(UnsupportedEncodingException e){
            e.printStackTrace();

        }catch(IOException e){
            e.printStackTrace();

        } catch(Exception e){
            e.printStackTrace();

        }
    }

    @Test
    public void getAllSuppliersTest() {
    }

    @Test
    public void getAllSiteManagersTest() {
    }

}

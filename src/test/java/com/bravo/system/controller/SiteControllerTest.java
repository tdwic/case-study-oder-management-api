package com.bravo.system.controller;

import com.bravo.system.model.Site;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class SiteControllerTest extends AbstractTest{

    public static final String ID = "1L";
    public static final String NAME = "Colombo";
    public static final String ADDRESS ="Colombo7";
    public static final String PHONE_NO = "0776453298";

    public static final String SITE_EXPECTED = "{\"id\":\"1L\",\"name\":\"Colombo\",\"address\":\"Colombo7\",\"phoneNo\":\"0776453298\"}";

    /**
     * Override method of the Extend class
     */
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    /**
     * Add Site Unit Test
     */
    @Test
    public void addSite() {
        try {
            String uri = "/addSite";
            Site site = new Site(ID, NAME, ADDRESS, PHONE_NO);
            String inputJson = super.mapToJson(site);
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(inputJson)).andReturn();

            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);

            String content = mvcResult.getResponse().getContentAsString();
            assertEquals(content,SITE_EXPECTED);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

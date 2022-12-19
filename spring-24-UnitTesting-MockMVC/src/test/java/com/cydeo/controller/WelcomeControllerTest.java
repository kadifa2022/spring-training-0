package com.cydeo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.*;                                    //import all method
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;   //all method Matchers

@WebMvcTest(WelcomeController.class)
public class WelcomeControllerTest {

    @Autowired
    private MockMvc mvc;    //because is not real test /we are using bean and autowire


    @Test
    void welcome_Test() throws Exception {//this is not performed way
        //call /welcome endpoint

        //My request interface     and abstract class       http method.get()
        RequestBuilder request = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);
                    //How to send  request-perform() and add acceptation throws
        MvcResult result = mvc.perform(request).andReturn();

        //verify response in "welcome" if returning 200
        assertEquals(200, result.getResponse().getStatus());//status
        assertEquals("welcome", result.getResponse().getContentAsString()); //what I'm expecting
    }
        @Test
         void welcome_Test2() throws Exception {//performed way
            RequestBuilder request= MockMvcRequestBuilders.get("/welcome")
                    .accept(MediaType.APPLICATION_JSON);
            mvc.perform(request)
                    .andExpect(status().isOk())//expecting status
                    .andExpect(content().string("welcome"))//verify expectedContent "welcome
                    .andReturn();

    }


}

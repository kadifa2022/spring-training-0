package com.cydeo.controller;
import com.cydeo.dto.StudentDTO;
import com.cydeo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean //Works      //@Mock is working with object directly
    StudentService studentService;//we are @mocking

    @Test
    void getStudent_Test() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/student")
                .accept(MediaType.APPLICATION_JSON))//header
                .andExpect(status().isOk())
                .andExpect(content().json("{\"firstName\": \"Mike\", \"lastName\": \"Smith\", \"age\": 20}")) //creating json object in string format
                .andDo(print())//to see information if test pass
                .andReturn();
    }
    @Test
    void jsonAssert_Test() throws Exception {//another way of insertion for json
        String expected = "{\"firstName\": \"Mike\", \"lastName\": \"Smith\", \"age\": 20}";
        String actual = mvc.perform(MockMvcRequestBuilders.get("/student")//real result
                .accept(MediaType.APPLICATION_JSON))//acceptation signature
                .andReturn().getResponse().getContentAsString();//compare two different Strings
        JSONAssert.assertEquals(expected, actual,true);

        //true is for exact matching
        // false is just for first and last name it is called (strict) test will pass)
        //expected = "{\"firstName\": \"Mike\",, \"lastName\": \"Smith\"}";
        //actual = "{\"firstName\": \"Mike\",, \"lastName\": \"Smith\", \"age\": 20}";
    }

    @Test
    void getStudents() throws Exception {
        when(studentService.getStudents()).thenReturn(Arrays.asList(      //when is coming from mockito library
                new StudentDTO("John", "Doe", 20),
                new StudentDTO("Tom", "Hanks", 50)
        ));

        // Creating my stub (behavior for my mock object/StudentService obj)

        mvc.perform(MockMvcRequestBuilders.get("/students")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content()//return except
                        .json("[{\"firstName\": \"John\", \"lastName\":  \"Doe\", \"age\": 20}" +
                                ", {\"firstName\": \"Tom\", \"lastName\":  \"Hanks\", \"age\": 50}]"))
                .andDo(print())
                .andReturn();

    }





}

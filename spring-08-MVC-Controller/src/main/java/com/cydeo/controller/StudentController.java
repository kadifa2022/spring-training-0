package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @RequestMapping("/student")
    public String getStudentInfo(){
        return "student/welcome.html";//if is in folder we need to put folder first/html
    }
}

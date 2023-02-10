package com.cydeo.controller;

import com.cydeo.model.Student2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController2 {
    @RequestMapping("student2")
    public String homepage2(Model model) {

        Student2 student2 = new Student2(20, "Bella ", "White ", "Black");
        model.addAttribute("student2" , student2);

        return "student2/student2-list";
    }
}

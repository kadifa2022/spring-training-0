package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {
    @RequestMapping("/welcome")
    public String homePage(Model model){//parameter to execute methode to belong  model Interface
        String name="Ozzy";



        model.addAttribute("name","Cydeo");
        model.addAttribute("course","MVC");
        String subject ="String Boot";
        model.addAttribute("Subject", subject);
        int studentId=new Random().nextInt();
        model.addAttribute("id",studentId);
        // collection
        List<Integer> numbers=new ArrayList<>();
        numbers.add(3);
        numbers.add(5);
        numbers.add(7);
        numbers.add(8);
        model.addAttribute("numbers", numbers);

        LocalDate dt=LocalDate.now();
        model.addAttribute("date",dt);
            //class -create object from Student class
        Student student = new Student(1,"Mike", "Schmidt");
        model.addAttribute("student", student);



        return "student/welcome";
    }
}

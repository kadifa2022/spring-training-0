package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    public CourseService getCourseService() {
        return courseService;
    }

    @GetMapping
   // @ResponseBody//no view anymore//
    public List<CourseDTO> getAllCourses(){
        return courseService.getCourses();
    }






}

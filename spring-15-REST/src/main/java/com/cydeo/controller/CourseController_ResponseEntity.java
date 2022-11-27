package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import jdk.jfr.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
public class CourseController_ResponseEntity {
    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping    //get the list
    public ResponseEntity<List<CourseDTO>> getAllCourses(){//generic changing status code 200,...//modifying output
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version", "Cydeo.v2")
                .header("Operation", "Get List")
                .body(courseService.getCourses());//list -ResponseEntity
    }
    //get one
    @GetMapping({"{id}"})
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id")long courseId){
        return  ResponseEntity
                .ok(courseService.getCourseById(courseId)); //ok.200

    }
    @GetMapping("category/{name}")
    public ResponseEntity<List<CourseDTO>> getCourseCategory(@PathVariable("name") String category){
        return ResponseEntity.ok(courseService.getCoursesByCategory(category));
    }

}

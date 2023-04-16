package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {//


   private final CourseService courseService;//

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping    //whatever we input we will in <ResponseWrapper> we will see in the postman as JSON
    public ResponseEntity<ResponseWrapper> getAllCourses(){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("Version" , "Cydeo.V3")
                .body(new ResponseWrapper("Courses successfully retrieved", courseService.getCourses()));
    }


    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") Long courseId){
        return ResponseEntity
                .ok(new ResponseWrapper("course:" + courseId + "retrieved", courseService.getCourseById(courseId)));
    }
    @GetMapping("category/{name}")
    public ResponseEntity<ResponseWrapper> getCourseByCategory(@PathVariable("name")String category){
        return ResponseEntity.ok((new ResponseWrapper("category retrieved" , courseService.getCoursesByCategory(category))));
    }
    @PostMapping
    public ResponseEntity<ResponseWrapper> createCourse(@RequestBody CourseDTO course){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Opearation" , "Create")
                .body(new ResponseWrapper("Course successfully created ", courseService.createCourse(course)));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<CourseDTO> deleteCourseById(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
       return ResponseEntity.noContent().build();
    }

}

























package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;

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

    @GetMapping    //get the list -responseEntity class is from Spring framework
    public ResponseEntity<List<CourseDTO>> getAllCourses() {//generic changing status code 200->202 custom created...//modifying output
        return ResponseEntity//modifying output
                .status(HttpStatus.ACCEPTED)
                .header("Version", "Cydeo.V2")//we can pass more than one header
                .header("Operation", "Get List")
                .body(courseService.getCourses());//DATA is coming with body returning list -ResponseEntity
    }

    //get one
    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Long courseId) {
        return ResponseEntity.ok(courseService.getCourseById(courseId));
    }

    @GetMapping("category/{name}")
    public ResponseEntity<List<CourseDTO>> getCourseByCategory(@PathVariable("name") String category) {
        return ResponseEntity.ok(courseService.getCoursesByCategory(category));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course) {//201 created//202 accepted
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation", "Create")
                .body(courseService.createCourse(course));
    }
    @DeleteMapping("{id}")//can be also CourseDTO instead Void
    public ResponseEntity<Void> deleteCourseById(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();

    }
    @PutMapping("{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable("id") Long courseId, @RequestBody CourseDTO course){
        courseService.updateCourse(courseId, course);
        return ResponseEntity.noContent().build();
    }




    }

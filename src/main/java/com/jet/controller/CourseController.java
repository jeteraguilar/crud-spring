package com.jet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jet.model.Course;
import com.jet.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {
    
    private final CourseRepository courseRepository;    

    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @PostMapping 
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody Course course) {
        //System.out.println(course.getName());
        courseRepository.save(course);
    }
}

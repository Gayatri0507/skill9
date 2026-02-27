package com.klu;

import org.springframework.web.bind.annotation.*;

import com.klu.exception.InvalidInputException;


@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {

        try {
            Long studentId = Long.parseLong(id);
            return service.getStudentById(studentId);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid student ID format. ID must be numeric.");
        }
    }
}
package com.klu;

import org.springframework.stereotype.Service;

import com.klu.exception.StudentNotFoundException;


@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with ID: " + id));
    }
}
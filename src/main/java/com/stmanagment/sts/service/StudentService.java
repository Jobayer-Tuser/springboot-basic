package com.stmanagment.sts.service;

import java.util.List;

import com.stmanagment.sts.interfaces.StudentServiceInterface;
import com.stmanagment.sts.model.Student;
import com.stmanagment.sts.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInterface{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}

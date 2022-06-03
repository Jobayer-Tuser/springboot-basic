package com.stmanagment.sts.interfaces;

import com.stmanagment.sts.model.Student;

import java.util.List;

public interface StudentServiceInterface {

    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}

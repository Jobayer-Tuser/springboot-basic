package com.stmanagment.sts.repository;

import com.stmanagment.sts.model.Course;
import com.stmanagment.sts.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void insertTeacherData()     {
        Course courseCSE = Course.builder()
                .title("CSE")
                .credits(158)
                .build();
        Course courseEEE = Course.builder()
                .title("EEE")
                .credits(148)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Nirjhor")
                .lastName("Anjum")
                .courses(List.of(courseCSE, courseEEE))
                .build();
        teacherRepository.save(teacher);
    }
}
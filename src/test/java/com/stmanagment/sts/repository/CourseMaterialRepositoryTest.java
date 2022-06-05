package com.stmanagment.sts.repository;

import com.stmanagment.sts.model.Course;
import com.stmanagment.sts.model.CourseMaterial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void insertCourseMaterial(){

        Course course = Course.builder()
                .title("CSE")
                .credits(158)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.facebook.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void getAllCourseMaterial(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }
}
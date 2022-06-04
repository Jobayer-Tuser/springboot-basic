package com.stmanagment.sts.repository;

import com.stmanagment.sts.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Chemistry")
                .departmentAddress("Dhaka")
                .departmentCode("CH-105")
                .build();
        entityManager.persist(department);
    }

    @Test
    @Disabled
    public void Test_findById(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Chemistry");
    }
}
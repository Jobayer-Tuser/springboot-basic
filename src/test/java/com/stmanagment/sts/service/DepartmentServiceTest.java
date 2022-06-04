package com.stmanagment.sts.service;

import com.stmanagment.sts.model.Department;
import com.stmanagment.sts.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class DepartmentServiceTest {

    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setup(){
        Department department = Department.builder()
                .departmentName("Bangla")
                .departmentAddress("Dhaka")
                .departmentCode("BN-123")
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Bangla")).thenReturn(department);
    }

    @Test
    @DisplayName("Found department")
    //@Disabled
    public void Test_findDepartmentByName(){
        String departmentName = "Bangla";
        Department found = departmentService.findDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}

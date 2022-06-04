package com.stmanagment.sts.controller;

import com.stmanagment.sts.exception.DepartmentNotFoundException;
import com.stmanagment.sts.interfaces.DepartmentServiceInterface;
import com.stmanagment.sts.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentServiceInterface departmentServiceInterface;
    private Department department;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Chemistry")
                .departmentAddress("Dhaka")
                .departmentCode("CH-105")
                .departmentCode("1L")
                .build();
    }

    @Test
    public void Test_store() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("Chemistry")
                .departmentAddress("Dhaka")
                .departmentCode("CH-105")
                .build();
        Mockito.when(departmentServiceInterface.insertDepartment(inputDepartment)).thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.post("/department/store")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\" : \"Chemistry\",\n" +
                        "    \"departmentAddress\": \"Dhaka\",\n" +
                        "    \"departmentCode\" : \"CH-105\"   \n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void Test_show() throws Exception {
        Mockito.when(departmentServiceInterface.findDepartmentById(1L)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/department/show/9")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}
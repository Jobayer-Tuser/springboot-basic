package com.stmanagment.sts.controller;

import com.stmanagment.sts.exception.DepartmentNotFoundException;
import com.stmanagment.sts.interfaces.DepartmentServiceInterface;
import com.stmanagment.sts.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentServiceInterface departmentServiceInterface;
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping
    public List<Department> index(){
        return departmentServiceInterface.getAllDepartment();
    }

    @PostMapping("store")
    public Department store(@Valid @RequestBody Department department){
        logger.info("Inside save department function");
        return departmentServiceInterface.insertDepartment(department);
    }

    @GetMapping("show/{id}")
    public Department show(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentServiceInterface.findDepartmentById(id);
    }

    @PutMapping("update/{id}")
    public Department update(@PathVariable Long id, @RequestBody Department department){
        return departmentServiceInterface.updateDepartmentById(id, department);
    }

    @DeleteMapping("destroy/{id}")
    public String destroy(@PathVariable("id") Long id){
        departmentServiceInterface.deleteDepartmentById(id);
        return "Deleted department";
    }

    @GetMapping("showByName/{name}")
    public Department findDepartmentByName(@PathVariable("name") String departmentName){
        return departmentServiceInterface.findDepartmentByName(departmentName);
    }

}

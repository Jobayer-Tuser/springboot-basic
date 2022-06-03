package com.stmanagment.sts.interfaces;

import com.stmanagment.sts.model.Department;

import java.util.List;

public interface DepartmentServiceInterface {
    public Department insertDepartment(Department department);
    public List<Department> getAllDepartment();
    public Department findDepartmentById(Long id);
    public void deleteDepartmentById(Long id);
    public Department updateDepartmentById(Long id, Department department);
    public Department findDepartmentByName(String departmentName);
}

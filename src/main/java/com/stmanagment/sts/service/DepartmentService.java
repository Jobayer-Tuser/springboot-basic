package com.stmanagment.sts.service;

import com.stmanagment.sts.exception.DepartmentNotFoundException;
import com.stmanagment.sts.interfaces.DepartmentServiceInterface;
import com.stmanagment.sts.model.Department;
import com.stmanagment.sts.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService implements DepartmentServiceInterface {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    @Override
    public Department insertDepartment(Department department){
        return departmentRepository.save(department);
    }
    @Override
    public Department findDepartmentById(Long id) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(id);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("No Department found with the provided id");
        }
        return department.get();
    }

    @Override
    public Department updateDepartmentById(Long id, Department department){

        Department departmentToUpdate = departmentRepository.findById(id).get();

        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            departmentToUpdate.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            departmentToUpdate.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            departmentToUpdate.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(departmentToUpdate);
    }

    @Override
    public void deleteDepartmentById(Long id){
        departmentRepository.deleteById(id);
    }

    @Override
    public Department findDepartmentByName(String departmentName){
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}

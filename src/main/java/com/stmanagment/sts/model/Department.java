package com.stmanagment.sts.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    @NotBlank(message = "Department name not given please input the name")
    private String departmentName;
    @Column(name = "address")
    private String departmentAddress;
    @Column(name = "code")
    private String departmentCode;

    public Department(){}
    public Department(Long id, String departmentName, String departmentAddress, String departmentCode){
        this.id = id;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress(){
        return departmentAddress;
    }
    public void setDepartmentAddress(String departmentAddress){
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode(){
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode){
        this.departmentCode = departmentCode;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }
}

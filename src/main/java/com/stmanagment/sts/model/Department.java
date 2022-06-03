package com.stmanagment.sts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}

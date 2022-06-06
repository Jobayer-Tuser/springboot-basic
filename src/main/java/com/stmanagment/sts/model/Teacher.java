package com.stmanagment.sts.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "teachers")
@ToString(exclude = "courses")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id"

    )
    @OneToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
    private List<Course> courses;
}

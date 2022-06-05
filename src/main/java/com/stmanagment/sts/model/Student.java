package com.stmanagment.sts.model;

import ch.qos.logback.classic.db.names.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "students",
        uniqueConstraints = @UniqueConstraint(columnNames = "email_address")
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    @Column(name = "email_address", nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;
}

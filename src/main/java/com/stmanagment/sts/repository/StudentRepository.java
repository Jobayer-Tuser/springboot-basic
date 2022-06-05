package com.stmanagment.sts.repository;
import com.stmanagment.sts.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByLastNameNotNull();
    public List<Student> findByGuardianName(String guardianName);
    public Student findByFirstNameAndLastName(String firstName, String lastName);
    //JPQL Query
    @Query("select s from Student s where s.emailId = ?1 ")
    public Student getStudentByEmailAddress(String EmailId);
    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailAddress(String emailId);
    //Native SQL query
    @Query(value = "SELECT * FROM students WHERE email_address = ?1", nativeQuery = true)
    public Student getStudentByEmailAddressWithNativeQuery(String emailId);

    //Native SQL query with param
    @Query(value = "SELECT * FROM students WHERE email_address = :emailId", nativeQuery = true)
    public Student getStudentByEmailAddressWithNativeQueryNamedParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE students SET first_name = ?1 WHERE email_address = ?2", nativeQuery = true)
    public int updateStudentFirstNameBasedOnEmailAddress(String firstName, String emailId);
}

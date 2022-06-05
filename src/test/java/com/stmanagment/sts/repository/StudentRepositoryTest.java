package com.stmanagment.sts.repository;

import com.stmanagment.sts.model.Guardian;
import com.stmanagment.sts.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("jobayer.tuser@gmail.com")
                .firstName("Jobayer")
                .lastName("Tuser")
                /*.guardianName("Abu baker Siddik")
                .guardianEmail("abu.baker@gmail.com")
                .guardianMobile("01714722079")*/
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("Abu baker Siddik")
                .email("abu.baker@gmail.com")
                .mobile("01714722079")
                .build();

        Student student = Student.builder()
                .emailId("prince.sibgatulla@gmail.com")
                .firstName("Prince")
                .lastName("Sibgatullah")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void getAllStudentList(){
        List<Student> students = studentRepository.findAll();
        System.out.println("Student list: " + students  );
    }

    @Test
    public void getStudentByFirstname(){
        List<Student> students = studentRepository.findByFirstName("Jobayer");
        System.out.println("Student: " + students);
    }

    @Test
    public void getStudentByFirstNameContain(){
        List<Student> students = studentRepository.findByFirstNameContaining("pr");
        System.out.println("Student: " + students);
    }

    @Test
    public void getStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Abu Baker Siddik");
        System.out.println("Student: " + students);
    }

    @Test
    public void getStudentBasedOnEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("jobayer.tuser@gmail.com");
        System.out.println("Student: " + student);
    }

    @Test
    public void getStudentFirstNameBasedOnEmailAddress() {
        String studentName = studentRepository.getStudentFirstNameByEmailAddress("jobayer.tuser@gmail.com");
        System.out.println("StudentName: " + studentName);
    }
}

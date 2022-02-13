package com.spring_boot_jpa.repository;

import com.spring_boot_jpa.entity.Guardian;
import com.spring_boot_jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudents() {
        Student student = Student.builder()
                .emailId("test1@gmail.com")
                .firstName("Test1")
                .lastName("Test1")
                //.guardianName("Guardian")
                //.guardianEmail("g@gmail.com")
                //.guardianMobile("33441122")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Johnson")
                .email("johnson@gmail.com")
                .mobile("36899001")
                .build();
        Student student = Student.builder()
                .firstName("Tim")
                .lastName("Doe")
                .emailId("tim@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> students = studentRepository.findAll();
        System.out.println("List of students = " + students);
    }
    @Test
    public void printStudentByFirstName() {
        List<Student> student = studentRepository.findByFirstName("Tom");
        System.out.println(student);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> student = studentRepository.findByFirstNameContaining("T");
        System.out.println(student);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("John");
        System.out.println(students);
    }

    @Test
    public void printStudentByEmail(){
        Student student = studentRepository.getStudentByEmailAddress("tom@gmail.com");

        System.out.println(student);
    }

    @Test
    public void printStudentNameByEmail(){
        String student = studentRepository.getStudentFirstNameByEmailAddress("tom@gmail.com");

        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("tom@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("tom@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailId() {
        studentRepository.updateStudentNameByEmailId("Tomas", "tom@gmail.com");
    }
}
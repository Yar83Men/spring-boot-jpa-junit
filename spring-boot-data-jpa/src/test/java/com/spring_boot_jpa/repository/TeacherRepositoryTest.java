package com.spring_boot_jpa.repository;

import com.spring_boot_jpa.entity.Course;
import com.spring_boot_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course course1 = Course.builder()
                .title("Roblox")
                .credit(2000)
                .build();
        Course course2 = Course.builder()
                .title("JavaScript")
                .credit(3000)
                .build();
        Course course3 = Course.builder()
                .title("Python")
                .credit(4000)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Ricky")
                .lastName("Martin")
                //.courses(List.of(course1, course2, course3))
                .build();
        teacherRepository.save(teacher);
    }


}
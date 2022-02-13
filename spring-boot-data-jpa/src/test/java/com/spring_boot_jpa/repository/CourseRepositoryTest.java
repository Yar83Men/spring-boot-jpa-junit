package com.spring_boot_jpa.repository;

import com.spring_boot_jpa.entity.Course;
import com.spring_boot_jpa.entity.Student;
import com.spring_boot_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courseList = courseRepository.findAll();

        System.out.println(courseList);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Mick")
                .lastName("Horn")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(100)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Ivan")
                .lastName("Connor")
                .build();

        Student student = Student.builder()
                .firstName("Andrey")
                .lastName("Maximus")
                .emailId("andy@gmail.com")
                .build();

        Course course = Course.builder()
                .title("React.js")
                .credit(12000)
                .teacher(teacher)
                .build();

        course.addStudents(student);
        courseRepository.save(course);
    }
}
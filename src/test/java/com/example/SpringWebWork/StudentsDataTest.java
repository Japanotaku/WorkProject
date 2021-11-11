package com.example.SpringWebWork;

import com.example.SpringWebWork.Entity.Student;
import com.example.SpringWebWork.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class StudentsDataTest {
    private StudentService studentService;
    private Student student;
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @BeforeClass
    public void before() {
        student = new Student("Almaz","Bekbergen",1L,4.0,"Almaty");
    }
    @Test
    public void something(){
        System.out.println("dd");
    }





}

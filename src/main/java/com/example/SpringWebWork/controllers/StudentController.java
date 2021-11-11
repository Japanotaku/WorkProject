package com.example.SpringWebWork.controllers;


import com.example.SpringWebWork.Entity.Student;
import com.example.SpringWebWork.repositories.StudentMapper;

import com.example.SpringWebWork.repositories.specifications.StudentSpecs;
import com.example.SpringWebWork.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("students")
public class StudentController {
    private StudentService studentService;
    private StudentMapper studentMapper;
    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public String showStudentsList(Model model,
                                   @RequestParam(value="page",required = false) Integer page,
                                   @RequestParam(value="lastName",required = false)String lastName,
                                   @RequestParam(value="firstName",required = false) String firstName,
                                   @RequestParam(value="city",required = false)String city,
                                   @RequestParam(value="minGpa",required = false)BigDecimal minGpa,
                                   @RequestParam(value="maxGpa",required = false)BigDecimal maxGpa
    ) {
        if(page == null){
            page = 1;
        }
        Specification<Student> specification = Specification.where(null);
        if(lastName != null){
            specification = specification.and(StudentSpecs.lastNameContains(lastName));
        }
        if(firstName != null){
            specification = specification.and(StudentSpecs.firstNameContains(firstName));
        }
        if(city != null){
            specification = specification.and(StudentSpecs.cityContains(city));
        }
        if(minGpa != null){
            specification = specification.and(StudentSpecs.gpaGreaterThanOrEq(minGpa));
        }
        if(maxGpa != null){
            specification = specification.and(StudentSpecs.gpaLessThanOrEq(maxGpa));
        }
        Student student = new Student();
        model.addAttribute("students",studentService.getStudentsWithPagingAndFiltering(specification, PageRequest.of(page-1,5)).getContent());
        model.addAttribute("student", student);
        model.addAttribute("lastName",lastName);
        model.addAttribute("firstName",firstName);
        model.addAttribute("city",city);
        model.addAttribute("minGpa",minGpa);
        model.addAttribute("maxGpa",maxGpa);
        return "students";
    }
    @PostMapping("/edit")
    public String addStudent(@ModelAttribute(value = "product")Student student) {
        studentService.saveOrUpdate(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id) {
        Student student = studentMapper.findById(id);
        studentMapper.delete(student);
        return "redirect:/students";
    }
    @GetMapping("/show/{id}")
    public String showOneStudent(Model model, @PathVariable(value = "id") Long id) {
        Student student = studentMapper.findById(id);
        model.addAttribute("student", student);
        return "student-page";
    }
    @GetMapping("/edit{id}")
    public String showAddStudentForm(Model model,@PathVariable(value= "id")Long id){
        Student student = studentMapper.findById(id);
        model.addAttribute("student",student);
        return "student-change";
    }
    @GetMapping("/add")
    public String showAddStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "student-change";
    }
}

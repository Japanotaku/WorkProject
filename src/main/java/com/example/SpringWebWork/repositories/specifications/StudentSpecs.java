package com.example.SpringWebWork.repositories.specifications;


import com.example.SpringWebWork.Entity.Student;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class StudentSpecs {
    public static Specification<Student> lastNameContains(String word){
        return (Specification<Student>) (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.like(root.get("lastName"),"%" + word + "%");
    }
    public static Specification<Student> firstNameContains(String word){
        return (Specification<Student>) (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.like(root.get("firstName"),"%" + word + "%");
    }
    public static Specification<Student> cityContains(String word){
        return (Specification<Student>) (root,criteriaQuery,criteriaBuilder) -> criteriaBuilder.like(root.get("city"),"%" + word + "%");
    }
    public static Specification<Student> gpaGreaterThanOrEq(BigDecimal value){
        return (Specification<Student>) (root,criteriaQuery,criteriaBuilder) ->{
            return criteriaBuilder.greaterThanOrEqualTo(root.get("gpa"),value);
        };
    }
    public static Specification<Student> gpaLessThanOrEq(BigDecimal value){
        return (Specification<Student>) (root,criteriaQuery,criteriaBuilder) ->{
            return criteriaBuilder.lessThanOrEqualTo(root.get("gpa"),value);
        };
    }
}

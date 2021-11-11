package com.example.SpringWebWork.repositories;


import com.example.SpringWebWork.Entity.Student;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentsRepository  extends PagingAndSortingRepository<Student,Long>, JpaSpecificationExecutor<Student> {
}

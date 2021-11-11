package com.example.SpringWebWork;

import com.example.SpringWebWork.Entity.Student;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MappedTypes(Student.class)
@MapperScan("com.example.SpringWebWork.repositories")
@SpringBootApplication
public class SpringWebWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebWorkApplication.class, args);
	}

}

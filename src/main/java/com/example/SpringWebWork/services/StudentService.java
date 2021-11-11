package com.example.SpringWebWork.services;




import com.example.SpringWebWork.Entity.Student;
import com.example.SpringWebWork.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;



@Service
public class StudentService {
    private StudentsRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentsRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Page<Student> getStudentsWithPagingAndFiltering(Specification<Student> specifications, Pageable pageable){
        return studentRepository.findAll(specifications, pageable);
    }
    public Student getById(Long id){
        return studentRepository.findById(id).orElse(null);
    }
    public void delete(Student student){
        studentRepository.deleteById(student.getId());
    }
    public void saveOrUpdate(Student student){
        studentRepository.save(student);
    }

}

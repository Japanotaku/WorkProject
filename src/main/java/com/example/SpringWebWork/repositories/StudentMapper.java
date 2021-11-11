package com.example.SpringWebWork.repositories;

import com.example.SpringWebWork.Entity.Student;
import org.apache.ibatis.annotations.*;



@Mapper
public interface StudentMapper {
    @Select("select * from students where id=#{id}")
    Student findById(Long id);

    @Insert("insert into students (lastname, firstname, city, gpa)  values(#{lastname},#{firstname},#{city},#{gpa})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Long.class)
    void insert(Student student);

    @Delete("delete from students where id=#{id}")
    void delete(Student student);
}

package com.example.SpringWebWork.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    @Column(name="id")
    private Long id;

    @Column(name="lastname")
    private String lastName;

    @Column(name="firstname")
    private String firstName;

    @Column(name="city")
    private String city;

    @Column(name="gpa")
    private Double gpa;

    public Student(String firstName, String lastName, Long id, Double gpa, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gpa = gpa;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", gpa=" + gpa +
                ", city='" + city + '\'' +
                '}';
    }
}

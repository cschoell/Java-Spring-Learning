package com.example.demo.student.entity;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence" 
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    public Student() {

    }

    public Student(Long id,
            String name,
            String email,
            LocalDate dob) {
                this.id = id;
                this.name = name;
                this.email = email;
                this.dob = dob;
    }

    public Student(
            String name,
            String email,
            LocalDate dob) {
                this.name = name;
                this.email = email;
                this.dob = dob;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
        // this helps us get the age of the student from their DOB and the current date
    }


    @Override
    public String toString() {
        return "Student{" +
            " id='" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", dob='" + dob +
            "}";
    }

}

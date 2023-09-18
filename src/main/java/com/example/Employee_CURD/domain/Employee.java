package com.example.Employee_CURD.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String employeename;
    private String domain;
    private int salary;
    public Employee() {

    }
    public Employee(Long id, String employeename, String domain, int salary) {
    
        this.id = id;
        this.employeename = employeename;
        this.domain = domain;
        this.salary = salary;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStudentname() {
        return employeename;
    }
    public void setStudentname(String employeename) {
        this.employeename = employeename;
    }
    public String getCourse() {
        return domain;
    }
    public void setCourse(String domain) {
        this.domain = domain;
    }
    public int getFee() {
        return salary;
    }
    public void setFee(int salary) {
        this.salary = salary;
    }

}
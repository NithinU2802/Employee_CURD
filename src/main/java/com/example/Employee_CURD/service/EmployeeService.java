package com.example.Employee_CURD.service;

import java.util.List;
import com.example.Employee_CURD.domain.Employee;
import com.example.Employee_CURD.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository repo;
    
    public List<Employee> listAll() {
        return repo.findAll();
    }
     
    public void save(Employee std) {
        repo.save(std);
    }
     
    public Employee get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}
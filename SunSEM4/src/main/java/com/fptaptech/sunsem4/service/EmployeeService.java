package com.fptaptech.sunsem4.service;

import com.fptaptech.sunsem4.entity.Employee;
import com.fptaptech.sunsem4.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Employee> findAll(){
        return employeeRepository.findAll();
    }


    public Optional<Employee> findById(String id){
        return employeeRepository.findById(id);
    }

    public Employee save(Employee employee){
        return  employeeRepository.save(employee);
    }

}

package com.fptaptech.sunsem4.controller;

import com.fptaptech.sunsem4.entity.Employee;
import com.fptaptech.sunsem4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Employee>> getList(){
        return ResponseEntity.ok(employeeService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String id){
        Optional<Employee> optionalEmployee = employeeService.findById(id);
        if (!optionalEmployee.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalEmployee.get());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @RequestMapping(method = RequestMethod.PUT,path = "{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee updateEmployee,@PathVariable String id){
        Optional<Employee> optionalEmployee = employeeService.findById(id);
        if (!optionalEmployee.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Employee employee = optionalEmployee.get();
        employee.setName(updateEmployee.getName());
        employee.setWage(updateEmployee.getWage());
        employee.setStatus(updateEmployee.getStatus());
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @RequestMapping(method = RequestMethod.PUT,path = "delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id){
        Optional<Employee> optionalEmployee = employeeService.findById(id);
        if (!optionalEmployee.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Employee employee = optionalEmployee.get();
        if (employee.getStatus() == -1){
            ResponseEntity.badRequest().build();
        }
        employee.setStatus(-1);
        return ResponseEntity.ok(employeeService.save(employee));
    }

}

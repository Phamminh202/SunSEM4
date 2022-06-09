package com.fptaptech.sunsem4.repository;

import com.fptaptech.sunsem4.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,String> {
}

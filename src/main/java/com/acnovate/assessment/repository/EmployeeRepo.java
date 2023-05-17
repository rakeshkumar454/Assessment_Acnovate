package com.acnovate.assessment.repository;

import com.acnovate.assessment.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Employee findByName(String name);
    Employee findBySupervisor(String supervisor);
}

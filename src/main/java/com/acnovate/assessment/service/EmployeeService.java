package com.acnovate.assessment.service;

import com.acnovate.assessment.Entities.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public String createEmployee(Map<String,String> employees);
    public Map<String, String> getSupervisorsByName(String name);
    public List<Employee> getAll();
}

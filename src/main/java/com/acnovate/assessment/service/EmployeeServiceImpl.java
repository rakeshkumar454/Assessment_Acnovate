package com.acnovate.assessment.service;

import com.acnovate.assessment.Entities.Employee;
import com.acnovate.assessment.exception.EmployeeNotFoundException;
import com.acnovate.assessment.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    /*
     * @Description : this method is used to Post of employees data in JSON format
     *
     * @Created by : Rakesh Kumar Guru
     *
     * @Created Date : 16 May 2023
     *
     */
    @Override
    public void createEmployee(Map<String, String> employees) {
        employees.forEach((name, supervisor)->{
            Employee employee = new Employee();
            employee.setName(name);
            employee.setSupervisor(supervisor);
            employeeRepo.save(employee);
        });
    }

    /*
     * @Description : this method is used to get of employees data based on name parameter
     *
     * @Created by : Rakesh Kumar Guru
     *
     * @Created Date : 16 May 2023
     *
     */
    @Override
    public Map<String, String> getSupervisorsByName(String name) {

        try {
            Employee employee = employeeRepo.findByName(name);
            if (employee == null) {
                throw new EmployeeNotFoundException("Employee", "name", name);
            }
            Map<String, String> supervisors = new HashMap<>();
            supervisors.put("supervisors", employee.getSupervisor());
            Employee supervisor = employeeRepo.findBySupervisor(employee.getSupervisor());
            if (supervisor != null) {
                supervisors.put("supervisorOfSupervisors", supervisor.getSupervisor());
            }
            return supervisors;
        } catch (EmployeeNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve supervisors", e);
        }
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }
}

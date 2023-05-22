package com.acnovate.assessment.controllers;

import com.acnovate.assessment.Entities.Employee;
import com.acnovate.assessment.exception.EmployeeNotFoundException;
import com.acnovate.assessment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Map<String, String> employees){
        employeeService.createEmployee(employees);
        return ResponseEntity.ok("Successfully added employees!!!");
    }

    @GetMapping("/{name}/supervisor")
    public ResponseEntity<Map<String, String>> getSupervisors(@PathVariable String name){
        Map<String, String> supervisors = employeeService.getSupervisorsByName(name);
        if(supervisors == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(supervisors);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAll(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }
}

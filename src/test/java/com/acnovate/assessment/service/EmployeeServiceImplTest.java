package com.acnovate.assessment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.acnovate.assessment.Entities.Employee;
import com.acnovate.assessment.repository.EmployeeRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class EmployeeServiceImplTest {
    @MockBean
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    /**
     * Method under test:  EmployeeServiceImpl#createEmployee(Map)
     */
    @Test
    void testCreateEmployee2() {
        Employee employee = new Employee();
        employee.setEmp_Id(1);
        employee.setName("Name");
        employee.setSupervisor("Supervisor");
        when(employeeRepo.save(employee)).thenReturn(employee);

        HashMap<String, String> employees = new HashMap<>();
        employees.put("Key", "42");
        employeeServiceImpl.createEmployee(employees);
        verify(employeeRepo).save(Mockito.<Employee>any());
    }
    @Test
    void testCreateEmployee() {
        employeeServiceImpl.createEmployee(new HashMap<>());
        assertTrue(employeeServiceImpl.getAll().isEmpty());
    }

    /**
     * Method under test:  EmployeeServiceImpl#getSupervisorsByName(String)
     */
//    @Test
//    void testGetSupervisorsByName() {
//        Employee employee = new Employee();
//        employee.setEmp_Id(1);
//        employee.setName("Name");
//        employee.setSupervisor("Supervisor");
//        when(employeeRepo.findByName(Mockito.<String>any())).thenReturn(employee);
//        Map<String, String> actualSupervisorsByName = employeeServiceImpl.getSupervisorsByName("Name");
//        assertEquals(2, actualSupervisorsByName.size());
//        assertEquals("Supervisor", actualSupervisorsByName.get("SeniorSupervisors"));
//        assertEquals("Supervisor", actualSupervisorsByName.get("supervisors"));
//        verify(employeeRepo, atLeast(1)).findByName(Mockito.<String>any());
//    }
   /*
    * Method under test:  EmployeeServiceImpl#getAll()
   */
    @Test
    void testGetAll() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        when(employeeRepo.findAll()).thenReturn(employeeList);
        List<Employee> actualAll = employeeServiceImpl.getAll();
        assertSame(employeeList, actualAll);
        assertTrue(actualAll.isEmpty());
        verify(employeeRepo).findAll();

    }
}
package com.acnovate.assessment.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_Id;
    private String name;
    private String supervisor;

    public Employee() {
    }

    public Employee(int emp_Id, String name, String supervisor) {
        this.emp_Id = emp_Id;
        this.name = name;
        this.supervisor = supervisor;
    }

    public int getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(int emp_Id) {
        this.emp_Id = emp_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "emp_Id=" + emp_Id +
                ", emp_Name='" + name + '\'' +
                ", supervisor='" + supervisor + '\'' +
                '}';
    }
  
}

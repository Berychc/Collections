package com.collections.demo;

import com.collections.Employees.Employee;

import java.util.Collection;

public interface EmployeeSerive {
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> findAllEmployees();
}

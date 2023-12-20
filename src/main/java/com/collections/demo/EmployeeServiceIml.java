package com.collections.demo;

import com.collections.Employees.Employee;
import com.collections.Exceptions.EmployeeAlreadyAddedException;
import com.collections.Exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class EmployeeServiceIml implements EmployeeSerive{

    private final Map<String, Employee> employees;

    public EmployeeServiceIml() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }


}

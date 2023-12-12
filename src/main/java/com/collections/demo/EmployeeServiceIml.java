package com.collections.demo;

import com.collections.Employees.Employee;
import com.collections.Exceptions.EmployeeAlreadyAddedException;
import com.collections.Exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Service
public class EmployeeServiceIml implements EmployeeSerive{

    private final List<Employee> employeeList;

    public EmployeeServiceIml() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAllEmployees() {
        return Collections.unmodifiableCollection(employeeList);
    }


}

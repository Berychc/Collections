package com.collections.demo;

import com.collections.Employees.Employee;
import com.collections.Exceptions.EmployeeAlreadyAddedException;
import com.collections.Exceptions.EmployeeNotFoundException;
import com.collections.Exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employees = List.of(
            new Employee("Egor", "Veselov"),
            new Employee("Soup", "Maktavish"),
            new Employee("Saymon", "Railly"),
            new Employee("Price", "Capitan"),
            new Employee("Gas", "British"),
            new Employee("Vladimir", "Makarov"),
            new Employee("Shepard", "Goldeneagle"),
            new Employee("Lasvell", "Alkatal"),
            new Employee("Ghost", "Mowend")
    );

    private static final int maxEmploee = 10;

    public void addEmployee(String firstName, String lastName) {
        if (employees.size() == maxEmploee) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
            throw new EmployeeAlreadyAddedException();
        }

        employees.add(new Employee(firstName, lastName));
    }


    public void removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        if (employee != null) {
            employees.remove(employee);
        } else {
            throw new EmployeeNotFoundException();
        }

    }

    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }
}

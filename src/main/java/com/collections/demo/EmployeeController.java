package com.collections.demo;

import com.collections.Employees.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceIml employeeService;

    public EmployeeController(EmployeeServiceIml employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstname,
                              @RequestParam("lastName") String lastname) {
        return employeeService.addEmployee(firstname, lastname);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstname,
                               @RequestParam("lastName") String lastname) {
        return employeeService.removeEmployee(firstname, lastname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstname,
                               @RequestParam("lastName") String lastname) {
        return employeeService.findEmployee(firstname, lastname);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAllEmployees();
    }
}

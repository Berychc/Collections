package com.collections.demo;

import com.collections.Employees.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstname,
                              @RequestParam("lastName") String lastname) {
        employeeService.addEmployee(firstname, lastname);
        Employee employee = employeeService.findEmployee(firstname, lastname);
        return employee;
    }

    @DeleteMapping("/remove")
    public void removeEmployee(@RequestParam("firstName") String firstname,
                               @RequestParam("lastName") String lastname) {
        employeeService.removeEmployee(firstname, lastname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstname,
                               @RequestParam("lastName") String lastname) {
        Employee employee = employeeService.findEmployee(firstname, lastname);
        return employee;
    }
}

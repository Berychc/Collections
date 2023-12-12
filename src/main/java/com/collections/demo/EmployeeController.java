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
        return employeeService.findEmployee(firstname, lastname);
    }

    @DeleteMapping("/remove")
    public void removeEmployee(@RequestParam("firstName") String firstname,
                               @RequestParam("lastName") String lastname) {
        employeeService.removeEmployee(firstname, lastname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstname,
                               @RequestParam("lastName") String lastname) {
        return employeeService.findEmployee(firstname, lastname);
    }
}

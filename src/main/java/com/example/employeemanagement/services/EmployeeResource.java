package com.example.employeemanagement.services;

import com.example.employeemanagement.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
private final EmployeeServices employeeServices;

    public EmployeeResource(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>>getAllEmployees(){
        List<Employee>employees = employeeServices.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee>getEmployeesById(@ PathVariable("id") Long id){
        Employee employees = employeeServices.findEmployeeById(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee>addEmployee(@RequestBody Employee employee){
       Employee newEmployee = employeeServices.addEmployee(employee);
       return  new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeServices.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteEmployee(@PathVariable("id")Long id){
        employeeServices.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

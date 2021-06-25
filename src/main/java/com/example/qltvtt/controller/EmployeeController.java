package com.example.qltvtt.controller;

import com.example.qltvtt.entity.Author;
import com.example.qltvtt.entity.Employee;
import com.example.qltvtt.entitywrapper.AuthorWrapper;

import com.example.qltvtt.entitywrapper.EmployeeWrapper;
import com.example.qltvtt.repository.AuthorRepository;
import com.example.qltvtt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;


    @RequestMapping(value = "/employees",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @RequestMapping(value = "/employee",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee emp) {
        return employeeRepository.save(emp);
    }

    @RequestMapping(value = "/employee",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Employee updateEmployee(@RequestBody EmployeeWrapper emp) {
        Employee employee = new Employee(emp);
        System.out.println("emp:" + emp);
        return employeeRepository.save(employee);
    }

    @RequestMapping(value = "/employee/{empId}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteAuthor(@PathVariable("empId") Integer empId) {
        employeeRepository.deleteById(empId);
    }

    @RequestMapping(value = "employee")
    public String employee() {

        return "employee";
    }
}

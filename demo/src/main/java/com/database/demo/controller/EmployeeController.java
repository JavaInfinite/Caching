package com.database.demo.controller;

import com.database.demo.model.Employee;
import com.database.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping(value = "/saveEmployee")
    @Transactional
    public Employee save(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @GetMapping(value = "/getEmployee/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {

        return service.getEmployeeById(id);
    }

    @GetMapping(value = "/getPutEmployee/{id}")
    public Employee getPutEmployee(@PathVariable("id") Integer id) {

        return service.getPutEmployee(id);
    }

    @GetMapping(value = "/getEvictEmployee/{id}")
    public Employee getEvictEmployee(@PathVariable("id") Integer id) {

        return service.getEvictEmployee(id);
    }

    @PutMapping(value="/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }


}

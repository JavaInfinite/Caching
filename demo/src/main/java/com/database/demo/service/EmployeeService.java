package com.database.demo.service;

import com.database.demo.model.Employee;
import com.database.demo.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO eDao;

    @Cacheable("employee")
    public Employee getEmployeeById(int id) {
        return eDao.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        return eDao.save(employee);
    }

    @CacheEvict("employee")
    public Employee getEvictEmployee(int id) {
        return eDao.findById(id).orElse(null);
    }

    @CachePut("employee")
    public Employee getPutEmployee(int id) {
        return eDao.findById(id).orElse(null);
    }
}

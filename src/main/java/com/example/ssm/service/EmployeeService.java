package com.example.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ssm.mapper.EmployeeMapper;
import com.example.ssm.pojo.Employee;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAll() {

        List<Employee> employeeList = employeeMapper.selectByExample(null);
        return employeeList;
    }
}

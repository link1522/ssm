package com.example.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ssm.mapper.DepartmentMapper;
import com.example.ssm.pojo.Department;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getAll() {
        List<Department> departmentList = departmentMapper.selectByExample(null);
        return departmentList;
    }
}

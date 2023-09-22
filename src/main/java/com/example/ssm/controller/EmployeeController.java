package com.example.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ssm.pojo.Employee;
import com.example.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String getAllEmployees(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            Model model) {
        PageHelper.startPage(page, 10);
        List<Employee> employeeList = employeeService.getAll();

        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList, 5);

        model.addAttribute("pageInfo", pageInfo);

        return "index";
    }
}

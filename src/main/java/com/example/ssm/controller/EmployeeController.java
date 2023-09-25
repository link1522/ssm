package com.example.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ssm.pojo.Department;
import com.example.ssm.pojo.Employee;
import com.example.ssm.service.DepartmentService;
import com.example.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/employees")
    public String getAllEmployees(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            Model model) {
        // get employee list
        PageHelper.startPage(page, 10);
        List<Employee> employeeList = employeeService.getAll();

        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList, 5);

        model.addAttribute("pageInfo", pageInfo);

        // get Department list
        List<Department> departmentList = departmentService.getAll();

        model.addAttribute("departmentList", departmentList);

        return "index";
    }

    @PostMapping("/employee")
    @ResponseBody
    public String createEmployee(@Valid Employee employee, BindingResult bindingResult, HttpServletResponse response) {

        if (bindingResult.hasErrors()) {
            response.setStatus(400);
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            allErrors.forEach(error -> System.out.println(error.getDefaultMessage()));
            return "error";
        }
        System.out.println(employee);

        return "ok";
    }
}

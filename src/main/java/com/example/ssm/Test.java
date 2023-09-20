package com.example.ssm;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.ssm.mapper.DepartmentMapper;
import com.example.ssm.pojo.Department;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        DepartmentMapper departmentMapper = ac.getBean(DepartmentMapper.class);
        List<Department> departmentList = departmentMapper.selectByExample(null);

        departmentList.forEach(department -> System.out.println(department));

        ac.close();
    }
}

package com.example.ssm.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.ssm.pojo.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DepartmentMapperTest {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void testInsertDepartment() {
        departmentMapper.insertSelective(new Department(null, "品保部"));
    }
}

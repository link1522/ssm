package com.example.ssm.mapper;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.ssm.pojo.Employee;
import com.example.ssm.pojo.EmployeeExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class EmployeeMapperTest {
    @Autowired
    private SqlSession sqlSession;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testInsertManyEmployee() {
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        for (int i = 0; i < 100; i++) {
            String uuid = UUID.randomUUID().toString().substring(0, 5);
            employeeMapper.insertSelective(new Employee(null, uuid, uuid + "@aa.com",
                    5));
        }
    }

    @Test
    public void testSelectEmployeeByPrimaryKeyWithDepartment() {
        Employee employee = employeeMapper.selectByPrimaryKeyWithDepartment(10);
        System.out.println(employee);
    }

    @Test
    public void testSelectEmployeeByExampleWithDepartment() {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andNameEqualTo("Jack");

        List<Employee> employeeList = employeeMapper.selectByExampleWithDepartment(employeeExample);

        employeeList.forEach((employee) -> System.out.println(employee));
    }
}

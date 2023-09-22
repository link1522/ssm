package com.example.ssm.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
        "file:src/main/webapp/WEB-INF/dispatcherServlet.xml" })
public class EmployeeControllerTest {
    // 需要 @WebAppConfiguration 註解才可以自動裝配 WebApplicationContext
    @Autowired
    WebApplicationContext context;
    MockMvc mockMvc;

    @Before
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        // 模擬發送 get 請求到 /employees 且帶參數 page=1
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/employees").param("page", "1")).andReturn();

        MockHttpServletRequest request = result.getRequest();

        Object pageInfoAttribute = request.getAttribute("pageInfo");
        if (pageInfoAttribute instanceof PageInfo<?>) {
            PageInfo<?> pageInfo = (PageInfo<?>) pageInfoAttribute;
            System.out.println(pageInfo);
        }
    }
}

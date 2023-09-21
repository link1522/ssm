package com.example.ssm.pojo;

public class Employee {
    private Integer id;

    private String name;

    private String email;

    private Integer departmentId;

    public Employee() {
    }

    public Employee(Integer id, String name, String email, Integer departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
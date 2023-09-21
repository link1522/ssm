package com.example.ssm.pojo;

public class Employee {
    private Integer id;

    private String name;

    private String address;

    private Integer departmentId;

    public Employee() {
    }

    public Employee(Integer id, String name, String address, Integer departmentId) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
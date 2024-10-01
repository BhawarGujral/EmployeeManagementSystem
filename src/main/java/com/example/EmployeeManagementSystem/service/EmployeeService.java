package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public void addEmployee(Employee emp);

    public List<Employee> getAllEmployee();

    public Employee getEmpByID(int id);

    public void updateEmployee(Employee emp);

    public void deleteEmployee(int id);

    public List<Employee> getEmployeeByName(String name);

}

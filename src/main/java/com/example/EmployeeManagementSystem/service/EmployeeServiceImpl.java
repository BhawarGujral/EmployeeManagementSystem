package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<Integer,Employee> employeeMap = new HashMap<>();

    EmployeeServiceImpl(){
        employeeMap.put(1,new Employee(1,"Bhawar","Gujral","Bhawar@gmail.com"));
        employeeMap.put(2,new Employee(2,"Paras","Pandey","Paras@gmail.com"));
        employeeMap.put(3,new Employee(3,"Vanshika","Jalota","Stuti@gmail.com"));

    }

    @Override
    public void addEmployee(Employee emp) {
        employeeMap.put(emp.getId(),emp);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMap.values().stream().toList();
    }

    @Override
    public Employee getEmpByID(int id) {
        return employeeMap.get(id);
    }

    @Override
    public void updateEmployee(Employee emp) {
        employeeMap.put(emp.getId(),emp);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeMap.remove(id);
    }
}

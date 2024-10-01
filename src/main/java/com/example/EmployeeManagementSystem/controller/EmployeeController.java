package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public  String getAllEmployees(Model model){
        model.addAttribute("employeeList",employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/showAddEmployeeForm")
    public String showAddEmployee(Model model){
        model.addAttribute("employee",new Employee());
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "addEmployee";
        }
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model) {
        Employee emp = employeeService.getEmpByID(id);
        model.addAttribute("employee",emp);
        return "/updateEmployee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/searchEmployee")
    public String searchEmployee(@RequestParam int employeeId, Model model){
        Employee e = employeeService.getEmpByID(employeeId);
        model.addAttribute("employeeList",e);
        return "index";
    }

    @GetMapping("/searchEmployeeByName")
    public String searchEmployeeByName(@RequestParam String name, Model model){
        List<Employee> e = employeeService.getEmployeeByName(name);
        model.addAttribute("employeeList",e);
        return "index";
    }
}

package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findByFirstName(String name); //findby is the annotation given by spring then use the column name for search

    @Query(value = "select * from employee where first_name=?1 and last_name=?2",nativeQuery = true)
    List<Employee> findByCriteria(String fname,String lname);
}

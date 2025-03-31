package com.example.mysql;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> 
{
Employee findByName(String name);
List<Employee> findByCity(String city);
}

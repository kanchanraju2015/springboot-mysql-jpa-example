package com.example.mysql;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@RestController
public class EmployeeController
{
	@Autowired
	EmployeeRepository erepo;
@RequestMapping("/test") // http://localhost:8080/ if no mapping is given 
public String test()
{
	return "this is default test";
}
	@RequestMapping("/all")
	public List<Employee> allemployees()
	{
		return erepo.findAll();
	}
	@RequestMapping("/by/{name}")
	public Employee byname(@PathVariable String name)
	{
	return erepo.findByName(name);
	}
	@RequestMapping("/city/{city}")
	
	public List<Employee>bycity(@PathVariable String city)
	{
	return erepo.findByCity(city);
	}
	
	
	
@RequestMapping("/save")
public Employee save(@RequestBody Employee employee)
{
	
	return erepo.save(employee);
}
@RequestMapping("/del/{id}")
public String del(@PathVariable int id)
{
	erepo.deleteById(id);
	return "data deleted";
}
@RequestMapping("/{id}")
public Optional<Employee> byid(@PathVariable int id)
{
	return erepo.findById(id);
}
}

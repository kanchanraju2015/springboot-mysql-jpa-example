package com.example.mysql;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/save")
public Employee save()
{
	Employee e=new Employee();
	e.setAge(34);
	e.setCity("ramgarh");
	e.setCountry("india");
	e.setName("anuj kumar");
	return erepo.save(e);
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
package com.example.demo;


import Model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class EmployeesController {

      @GetMapping ("/employees")
    public List<Employees> getEmployees(){
          List<Employees> list=new LinkedList<>();
           Employees employees=new Employees(0,"小明",20,"男");
           Employees employees1=new Employees(1,"小红",19,"女");
           Employees employees2=new Employees(2,"小智",20,"男");
           list.add(employees);
           list.add(employees1);
           list.add(employees2);
          return  list;
      }

}
